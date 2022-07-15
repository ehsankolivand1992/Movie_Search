package com.sprout.movieslist.adapter.viewHolder

import android.content.Context
import com.sprout.baseui.BaseViewHolder
import com.sprout.baseui.util.image.GlideImageLoader
import com.sprout.domain.model.Movies
import com.sprout.movieslist.databinding.MovieItemsBinding

class MovieViewHolder(override  val binding: MovieItemsBinding,override val context: Context) : BaseViewHolder<Movies>(binding,
    context) {


    override fun bind(item: Movies, imageLoader: GlideImageLoader) {
        binding.txtYear.text = item.year.toString()
        binding.txtRate.text = item.rate.toString()
        binding.txtDuration.text = item.duration
        binding.txtTitle.text=item.title
        imageLoader.loadImage(binding.imgCover,item.posterImage.toString())
    }
}