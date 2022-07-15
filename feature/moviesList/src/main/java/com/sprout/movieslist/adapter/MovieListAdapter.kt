package com.sprout.movieslist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sprout.baseui.util.image.GlideImageLoader
import com.sprout.domain.model.Movies
import com.sprout.movieslist.adapter.viewHolder.MovieViewHolder
import com.sprout.movieslist.databinding.MovieItemsBinding

class MovieListAdapter(private val imageLoader: GlideImageLoader): RecyclerView.Adapter<MovieViewHolder>() {
    private var items:List<Movies> = emptyList()

    fun setAdapters(items: List<Movies>)
    {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       return MovieViewHolder(MovieItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false),parent.context)
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
       holder.bind(items[position],imageLoader)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}