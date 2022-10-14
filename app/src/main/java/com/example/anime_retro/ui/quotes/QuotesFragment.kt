package com.example.anime_retro.ui.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.anime_retro.databinding.FragmentAnimeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuotesFragment : Fragment() {
    private val viewModel by viewModels<QuotesViewModel>()
    private val adapter: QuotesAdapter by lazy { QuotesAdapter(context) }
    private lateinit var binding: FragmentAnimeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeBinding.inflate(layoutInflater, container, false)
        binding.recyclerview.adapter = adapter
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.event.collect {
                when (it) {
                    is Actions.Toast -> Toast.makeText(activity, it.message, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        viewModel.quote.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.rbAnimeQuotes.id -> viewModel.repositoryType = RepositoryType.Anime
                binding.rbTechQuotes.id -> viewModel.repositoryType = RepositoryType.Tech
                binding.rbMovieQuotes.id -> viewModel.repositoryType = RepositoryType.Movie
            }
            viewModel.refreshQuote()
        }


    }


}