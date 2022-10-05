package com.example.anime_retro.ui.anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.anime_retro.R
import com.example.anime_retro.databinding.FragmentAnimeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment() {
    private val viewModel by viewModels<AnimeViewModel>()
    private val adapter: AnimeAdapter by lazy { AnimeAdapter(context) }
    private lateinit var binding: FragmentAnimeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeBinding.inflate(layoutInflater, container, false)
        binding.recyclerview.adapter = adapter
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.anime.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }


}