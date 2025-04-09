package com.example.dress_up.model

import androidx.compose.runtime.mutableStateListOf
import com.example.dress_up.R

object IMGFactory {
    // (not body) 10 IMG
    fun makeIMGList() = mutableStateListOf(
        IMG(R.drawable.arms,"arms",IMGStatus.OFF),
        IMG(R.drawable.hat,"hat",IMGStatus.OFF),
        IMG(R.drawable.ears,"ears",IMGStatus.OFF),
        IMG(R.drawable.eyes,"eyes",IMGStatus.OFF),
        IMG(R.drawable.nose,"nose",IMGStatus.OFF),
        IMG(R.drawable.eyebrows,"eyebrows",IMGStatus.OFF),
        IMG(R.drawable.glasses,"glasses",IMGStatus.OFF),
        IMG(R.drawable.mouth,"mouth",IMGStatus.OFF),
        IMG(R.drawable.mustache,"mustache",IMGStatus.OFF),
        IMG(R.drawable.shoes,"shoes",IMGStatus.OFF),
    )
}