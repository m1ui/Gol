package com.raspopova.gol.inside.ui.news.data

data class News(
    val id: String, // id news
    val title: String, // news title
    val description: String, // news description
    val date: String, // published date
    val isLiked: Boolean // like or no
)
