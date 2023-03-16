package com.raspopova.gol.inside.ui.news.data

data class News(
    val id: Long, // id news
    val picture: String, // link for Image
    val title: String, // news title
    val description: String, // news description
    val date: String, // published date
    val isLiked: Boolean // like or no
)
