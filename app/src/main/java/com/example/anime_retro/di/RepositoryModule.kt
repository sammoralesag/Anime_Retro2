package com.example.anime_retro.di

import com.example.anime_retro.data.NetworkDataSource1
import com.example.anime_retro.data.NetworkDataSource2
import com.example.anime_retro.data.NetworkDataSource3
import com.example.anime_retro.data.remote.QuotesRepositoryImpl1
import com.example.anime_retro.data.remote.QuotesRepositoryImpl2
import com.example.anime_retro.data.remote.QuotesRepositoryImpl3
import com.example.anime_retro.domain.IQuotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    @Named("QuotesAnime")
    fun providesIAnimeRepository(dataSource: NetworkDataSource1): IQuotesRepository =
        QuotesRepositoryImpl1(dataSource)

    @Provides
    @Singleton
    @Named("QuotesTech")
    fun providesITechRepository(dataSource: NetworkDataSource2): IQuotesRepository =
        QuotesRepositoryImpl2(dataSource)

    @Provides
    @Singleton
    @Named("QuotesMovie")
    fun providesIMoviesRepository(dataSource: NetworkDataSource3): IQuotesRepository =
        QuotesRepositoryImpl3(dataSource)

}