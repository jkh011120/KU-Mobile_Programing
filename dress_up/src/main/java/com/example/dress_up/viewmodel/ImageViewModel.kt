package com.example.dress_up.viewmodel

import androidx.lifecycle.ViewModel
import com.example.dress_up.model.IMG
import com.example.dress_up.model.IMGFactory

class ImageViewModel:ViewModel() {
    private val _imageList = IMGFactory.makeIMGList()
    val imageList: MutableList<IMG>
        get() = _imageList
}