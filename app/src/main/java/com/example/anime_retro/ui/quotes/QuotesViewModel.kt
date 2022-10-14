package com.example.anime_retro.ui.quotes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_retro.Resource
import com.example.anime_retro.domain.IQuotesRepository
import com.example.anime_retro.domain.models.Quotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class QuotesViewModel @Inject constructor(
    @Named("QuotesMovie")
    private val movieRepository: IQuotesRepository,
    @Named("QuotesTech")
    private val techRepository: IQuotesRepository,
    @Named("QuotesAnime")
    private val animeRepository: IQuotesRepository,


    ) : ViewModel() {

    private val _event = Channel<Actions>()
    val event = _event.receiveAsFlow()
    private val _quote = MutableLiveData<List<Quotes>>()
    val quote: LiveData<List<Quotes>>
        get() = _quote
    var repositoryType: RepositoryType = RepositoryType.Anime

    init {
        refreshQuote()
    }

    fun refreshQuote() {
        val currentRepository = when (repositoryType) {
            is RepositoryType.Anime -> animeRepository
            is RepositoryType.Tech -> techRepository
            is RepositoryType.Movie -> movieRepository
        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (val result = currentRepository.getAllQuotes()) {
                    is Resource.Success -> result.data.let { _quote.postValue(it) }
                    is Resource.Failure -> _event.trySend(Actions.Toast(result.message.toString()))
                }

            } catch (e: Exception) {
                Log.e("", e.toString())
            }
        }

    }

}

sealed interface RepositoryType {
    object Anime : RepositoryType
    object Tech : RepositoryType
    object Movie : RepositoryType
}

sealed interface Actions {
    data class Toast(val message: String) : Actions
}