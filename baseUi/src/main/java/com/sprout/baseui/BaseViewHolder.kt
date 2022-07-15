package com.sprout.baseui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.sprout.baseui.util.image.GlideImageLoader


abstract class BaseViewHolder<T>(open val binding: ViewBinding, open val context: Context) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T,imageLoader: GlideImageLoader)
}
