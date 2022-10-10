package com.example.anime_retro.ui.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_retro.domain.IQuotesRepository
import com.example.anime_retro.domain.models.Quotes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class AnimeViewModel @Inject constructor(
    @Named("QuotesMovie")
    private val repository: IQuotesRepository
) : ViewModel() {

    private val _anime = MutableLiveData<List<Quotes>>()
    val anime: LiveData<List<Quotes>>
        get() = _anime

    init {
        refreshAnime()
    }

    fun refreshAnime(){
        viewModelScope.launch (Dispatchers.IO ){
            val list = repository.getAllQuotes()
            _anime.postValue(list)
        }
    }
}