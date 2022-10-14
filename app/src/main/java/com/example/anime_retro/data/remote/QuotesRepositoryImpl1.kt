package com.example.anime_retro.data.remote

import com.example.anime_retro.Resource
import com.example.anime_retro.data.NetworkDataSource1
import com.example.anime_retro.data.mapper.toDomain1

import com.example.anime_retro.domain.IQuotesRepository
import com.example.anime_retro.domain.models.Quotes
import javax.inject.Inject

class QuotesRepositoryImpl1 @Inject constructor(
    private val dataSource: NetworkDataSource1
) : IQuotesRepository {
    override suspend fun getAllQuotes(): Resource<List<Quotes>> {
        val response = dataSource.getAllQuotes()
        return Resource.Success(response?.map { it.toDomain1() } ?: emptyList())
    }
}