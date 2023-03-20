package com.raspopova.gol.inside.ui.translation.data

import android.provider.MediaStore.Video
import java.util.Date

data class Translation(
    val title: String,
    val video: Video,
    val isLicked: Boolean,
    val date: String
)
