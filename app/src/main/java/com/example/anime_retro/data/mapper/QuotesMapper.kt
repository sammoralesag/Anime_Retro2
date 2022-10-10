package com.example.anime_retro.data.mapper

import com.example.anime_retro.data.remote.models.Quote
import com.example.anime_retro.data.remote.models.QuotesResponse1Item
import com.example.anime_retro.domain.models.Quotes

fun QuotesResponse1Item.toDomain1(): Quotes = Quotes(
    id = this.anime ?: "",
    author = this.character ?: "",
    quote = this.quote ?: ""
)

fun com.example.anime_retro.data.remote.models.Result.toDomain2(): Quotes = Quotes(
    id = this.authorId ?: "",
    author = this.author ?: "",
    quote = this.content ?: ""
)

fun Quote.toDomain3(): Quotes = Quotes(
    id = this.tag ?: "",
    author = this.author ?: "",
    quote = this.text ?: ""
)