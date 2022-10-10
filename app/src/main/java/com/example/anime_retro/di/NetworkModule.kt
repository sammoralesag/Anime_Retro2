package com.example.anime_retro.di

import com.example.anime_retro.BuildConfig
import com.example.anime_retro.data.remote.Quotes1API
import com.example.anime_retro.data.remote.Quotes2API
import com.example.anime_retro.data.remote.Quotes3API
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton

    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }
    }.build()

    @Provides
    @Singleton
    @Named("AnimeAPI")
    fun providesAnimeRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.API_BASE_URL_1)
        .build()

    @Provides
    @Singleton
    @Named("TechAPI")
    fun providesTechRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.API_BASE_URL_2)
        .build()

    @Provides
    @Singleton
    @Named("MoviesAPI")
    fun providesMoviesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.API_BASE_URL_3)
        .build()

    @Provides
    @Singleton

    fun providesAnimeAPI(@Named("AnimeAPI") retrofit: Retrofit): Quotes1API = retrofit.create(Quotes1API::class.java)

    @Provides
    @Singleton

    fun providesTechAPI(@Named("TechAPI")retrofit: Retrofit): Quotes2API = retrofit.create(Quotes2API::class.java)

    @Provides
    @Singleton

    fun providesMoviesAPI(@Named("MoviesAPI")retrofit: Retrofit): Quotes3API = retrofit.create(Quotes3API::class.java)
}
