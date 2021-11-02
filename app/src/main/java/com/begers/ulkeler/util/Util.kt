package com.begers.ulkeler.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.begers.ulkeler.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

//Extension

fun ImageView.downloadFromUrl(url: String?, progressDrawable: CircularProgressDrawable){

    val option = RequestOptions()
            .placeholder(progressDrawable)
            .error(R.mipmap.ic_launcher)

    Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(url)
            .into(this)
}

fun placeHolderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}