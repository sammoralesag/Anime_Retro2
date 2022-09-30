package com.example.anime_retro.ui.anime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.anime_retro.databinding.ItemAnimeBinding
import com.example.anime_retro.domain.models.Anime

class AnimeAdapter(
) : ListAdapter<Anime, AnimeAdapter.AnimeViewHolder>(AnimeDiff()) {


    inner class AnimeViewHolder(private val itemBinding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(anime: Anime) {
            with(itemBinding) {
                tvAnime.text = anime.anime
                tvCharacter.text = anime.character
                tvQuote.text = anime.quote
            }
        }
    }

    class AnimeDiff() : DiffUtil.ItemCallback<Anime>() {
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.anime == newItem.anime
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
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