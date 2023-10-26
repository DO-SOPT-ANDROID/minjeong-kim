package org.sopt.dosopttemplate.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadUrl(imageUrl: String?) {
    Glide.with(this).load(imageUrl).into(this)
}