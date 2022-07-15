package com.sprout.baseui.util.image

import android.widget.ImageView


interface ImageLoadingService {
    fun loadImage(imageView: ImageView, imageUrl: String)
    fun loadImageLocal(imageView: ImageView,drawable: Int)
    fun loadGIF(imageView: ImageView, GIFUrl: String)
    fun loadGIFlocal(imageView: ImageView, GIFdrawable: Int)
    fun loadGIFLocalWithLoop(imageView: ImageView, GIFdrawable: Int)
}
