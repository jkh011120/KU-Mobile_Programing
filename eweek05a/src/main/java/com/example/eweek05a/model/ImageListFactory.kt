package com.example.eweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.eweek05a.R

object ImageListFactory {
    fun makeListImage() = mutableStateListOf(
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.EMOGI,
            likes = 100,
            dislikes = 10
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.BADGE,
            likes = 50
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.ICON,
            likes = 50
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.EMOGI,
            likes = 10,
            dislikes = 3
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            buttonType = ButtonType.EMOGI,
            likes = 13,
            dislikes = 17
        )
    )
}