package com.example.anime_retro.di

import com.example.anime_retro.data.remote.AnimeRepositoryImpl
import com.example.anime_retro.data.remote.NetworkDataSource
import com.example.anime_retro.domain.IAnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton

    fun providesIAnimeRepository(dataSource: NetworkDataSource): IAnimeRepository =
        AnimeRepositoryImpl(dataSource)

}