package com.raspopova.gol.inside

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.raspopova.gol.R
import kotlinx.android.synthetic.main.activity_video_more.*


@Suppress("DEPRECATION")
class VideoMoreActivity : AppCompatActivity() {

    private var stablePosition: Int = 0
    private var number: Int = 0
    private lateinit var uri: Uri
    private lateinit var mediaController: MediaController

    private val titles = arrayOf(
        "Ювентус - Монца",
        "Байер - Боруссия Дортмунд",
        "Лацио - Фиорентина",
        "Наполи - Рома",
        "Жеребьевка группового этапа Лиги чемпионов"
    )

    private val urls = arrayOf(
        "https://raspnewssoccer.ru/video/1.mp4",
        "https://raspnewssoccer.ru/video/2.mp4",
        "https://raspnewssoccer.ru/video/3.mp4",
        "https://raspnewssoccer.ru/video/4.mp4",
        "https://raspnewssoccer.ru/video/5.mp4",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_more)
        val intent: Intent = intent
        number = intent.getIntExtra("num", 0)
        title = titles[number]

        mediaController = MediaController(this)

        video_view.setOnPreparedListener {
            mediaController.setAnchorView(video_container)
            video_view.setMediaController(mediaController)
            video_view.seekTo(stablePosition)
            video_view.start()
        }
    }

    override fun onStart() {
        super.onStart()
        when(number) {
            0 -> {
                uri = Uri.parse(urls[number])
                video_view.setVideoURI(uri)
            }
            1 -> {
                uri = Uri.parse(urls[number])
                video_view.setVideoURI(uri)
            }
            2 -> {
                uri = Uri.parse(urls[number])
                video_view.setVideoURI(uri)
            }
            3 -> {
                uri = Uri.parse(urls[number])
                video_view.setVideoURI(uri)
            }
            4 -> {
                uri = Uri.parse(urls[number])
                video_view.setVideoURI(uri)
            }
            else -> {
                try {
                    finish()
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        video_view.pause()
        stablePosition = video_view.currentPosition
    }

    override fun onStop() {
        video_view.stopPlayback()
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }
}