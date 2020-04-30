package ru.systempla.life_hack_studio_test.model.image

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoader : IImageLoader<ImageView> {

    override fun loadInto(url: String?, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }
}