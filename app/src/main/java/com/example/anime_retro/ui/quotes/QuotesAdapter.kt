package com.example.anime_retro.ui.quotes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_retro.R
import com.example.anime_retro.databinding.ItemAnimeBinding
import com.example.anime_retro.domain.models.Quotes

class QuotesAdapter(val context: Context?)
    : ListAdapter<Quotes, QuotesAdapter.AnimeViewHolder>(AnimeDiff()) {


    inner class AnimeViewHolder(private val itemBinding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(anime: Quotes) {
            with(itemBinding) {
                tvAnime.text = context?.getString(R.string.anime,anime.id)
                tvCharacter.text = context?.getString(R.string.character,anime.author)
                tvQuote.text = context?.getString(R.string.quote, anime.quote)
            }
        }
    }

    class AnimeDiff : DiffUtil.ItemCallback<Quotes>() {
        override fun areItemsTheSame(oldItem: Quotes, newItem: Quotes): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Quotes, newItem: Quotes): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}