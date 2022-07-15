package com.sprout.baseui.util.image

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.ref.WeakReference
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class GlideImageLoader @Inject constructor(@ApplicationContext val context: Context):
    ImageLoadingService {
    override fun loadImage(imageView: ImageView, imageUrl: String) {
        val imageViewReference: WeakReference<ImageView> = WeakReference(imageView)
        val imageView2 = imageViewReference.get()
        if (imageView2 != null) {
            Glide.with(context)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false) //
                //            .placeholder(R.drawable.holder)
                .into(imageView2)
        }
    }

    override fun loadImageLocal(imageView: ImageView, drawable: Int) {
        val imageViewReference: WeakReference<ImageView> = WeakReference(imageView)
        val imageView2 = imageViewReference.get()
        if (imageView2 != null) {
            Glide.with(context)
                .load(drawable)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .skipMemoryCache(false) //
                //            .placeholder(R.drawable.holder)
                .into(imageView2)
        }
    }

    override fun loadGIF(imageView: ImageView, GIFUrl: String) {
        val imageViewReference: WeakReference<ImageView> = WeakReference(imageView)
        val imageView2 = imageViewReference.get()
        if (imageView2 != null) {
            Glide.with(context)
                .asGif()
                .load(GIFUrl)
                .into(imageView2)
        }
    }

    override fun loadGIFlocal(imageView: ImageView, GIFaddress: Int) {
        val imageViewReference: WeakReference<ImageView> = WeakReference(imageView)
        val imageView2 = imageViewReference.get()
        if (imageView2 != null) {
            Glide.with(context)
                .asGif()
                .load(GIFaddress)
                .listener(object : RequestListener<GifDrawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<GifDrawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        TODO("Not yet implemented")
                    }

                    override fun onResourceReady(
                        resource: GifDrawable?,
                        model: Any?,
                        target: Target<GifDrawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        resource?.setLoopCount(1)
                        return false
                    }

                })
                .into(imageView2)
        }
    }

    override fun loadGIFLocalWithLoop(imageView: ImageView, GIFdrawable: Int) {
        val imageViewReference: WeakReference<ImageView> = WeakReference(imageView)
        val imageView2 = imageViewReference.get()
        if (imageView2 != null) {
            Glide.with(context)
                .asGif()
                .load(GIFdrawable)
                .listener(object : RequestListener<GifDrawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<GifDrawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        TODO("Not yet implemented")
                    }

                    override fun onResourceReady(
                        resource: GifDrawable?,
                        model: Any?,
                        target: Target<GifDrawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        resource?.setLoopCount(100)
                        return false
                    }

                })
                .into(imageView2)
        }
    }
}
