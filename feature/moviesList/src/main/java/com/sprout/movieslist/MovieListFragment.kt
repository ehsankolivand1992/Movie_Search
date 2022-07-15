package com.sprout.movieslist

import android.os.Bundle
import android.util.Log
import android.view.View
import com.sprout.baseui.BaseFragment
import com.sprout.movieslist.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sprout.baseui.customlistinner.LoadingDialog
import com.sprout.baseui.util.edittext.DebouncingQueryTextListener
import com.sprout.baseui.util.image.GlideImageLoader
import com.sprout.domain.model.Movies
import com.sprout.domain.responseModel.ResultData
import com.sprout.movieslist.adapter.MovieListAdapter
import com.sprout.movieslist.viewModel.MovieListViewModel
import javax.inject.Inject


@AndroidEntryPoint
class MovieListFragment : BaseFragment<FragmentMovieListBinding>() {

    private val viewModel: MovieListViewModel by viewModels()
    lateinit var adapter: MovieListAdapter
    @Inject
    lateinit var imageLoader: GlideImageLoader


    override fun setBinding() = FragmentMovieListBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.setupList()
        this.handleLoading()
        this.startListeningQuery()
    }

    private fun setupList()
    {
        adapter = MovieListAdapter(imageLoader)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvMovieList.layoutManager = layoutManager
        binding.rvMovieList.adapter = adapter

    }

    private fun fetchMovies(query:String)
    {
        viewModel.searchMovies(query).observe(viewLifecycleOwner){
            when(it)
            {
                is ResultData.Success<List<Movies>> -> {
                    it.value?.let { it1 -> adapter.setAdapters(it1)
                    }
                }
                else -> {
                }
            }

        }
    }

    private fun startListeningQuery() {
        binding.searchView.setOnQueryTextListener(
            DebouncingQueryTextListener(
                this
            ) { newText ->
                newText?.let {
                    if (newText.length >= 2) {
                    this.fetchMovies(newText)
                    }
                }
            }
        )
    }

    private fun handleLoading()
    {
        viewModel.loading.observe(viewLifecycleOwner){
            Log.i("handleLoading","$it")
            (requireActivity() as LoadingDialog).showDialog(it)
        }
    }
}