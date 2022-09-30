package com.example.anime_retro.ui.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime_retro.domain.IAnimeRepository
import com.example.anime_retro.domain.models.Anime
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repository: IAnimeRepository
) : ViewModel() {

    private val _anime = MutableLiveData<List<Anime>>()
    val anime: LiveData<List<Anime>>
        get() = _anime

    init {
        refreshAnime()
    }

    fun refreshAnime(){
        viewModelScope.launch (Dispatchers.IO ){
            val list = repository.getAllAnime()
            _anime.postValue(list)
        }
    }
}