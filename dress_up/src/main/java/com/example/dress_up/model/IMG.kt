package com.example.dress_up.model

data class IMG(
    val image: Int, // painterResource
    val name : String, // img_name
    var status: IMGStatus = IMGStatus.OFF
)
