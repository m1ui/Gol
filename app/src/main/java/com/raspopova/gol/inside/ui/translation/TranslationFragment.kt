package com.raspopova.gol.inside.ui.translation

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.raspopova.gol.databinding.FragmentTranslitionBinding
import kotlinx.android.synthetic.main.fragment_translition.*


class TranslationFragment : Fragment() {

    private lateinit var mediaController: MediaController
    private var playBackPosition = 0
    private val streamUrl = "https://streaming.disk.yandex.net/hls/U2FsdGVkX1-7elPJWGHz30ahRkyP_R2qrPSX6K0RHlyOk6yUVfAa7Za3rJ7NZTxTwXDyLVHfzCcV2sL6G_jWs0-4LbOPEoT-nJNZbBUySYRORqfIPgx1SUaDTsURnEiQdOPijlNlXNK2NZxFBXYavTaMGoR22PNsepmgjOxjodk7qFNQaZy9gYEjER9oybRK7-i6f9CrhC_f6Ti-fhU-eXVJVIZBSK7x7FLxiklBFz8xxrPFf65YPuUrKm36AOQAh0AiROAnGQhGrC4pNDd99ROS3TumDPf6U5Q9mDjhO13g118T2bRoL-mUHW1D0lRc/5f80a267c1220/89b1394b949ff3b9b101545d9b12aec334e26988b06e897d05d83b118f33f8ca/240p/2.ts?partner-id=NaN&video-category-id=0&imp-id=undefined&gzip=1&from=disk&vsid=35dff651a2bf9edbd23e223a0912a597c64967864cc2xWEBx0195x1680010962&session_data=1&preview=1&t=1680010964631&ab=1"

    private var _binding: FragmentTranslitionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTranslitionBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mediaController = MediaController(context)
        videoView.setOnPreparedListener {
            mediaController.setAnchorView(video_container)
            videoView.setMediaController(mediaController)
            videoView.seekTo(playBackPosition)
            videoView.start()
        }

    }

    override fun onPause() {
        super.onPause()
        videoView.pause()
        playBackPosition = videoView.currentPosition
    }

    override fun onStop() {
        videoView.stopPlayback()

        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        videoView.seekTo(playBackPosition)
        videoView.start()
    }

    override fun onStart() {
        super.onStart()
        val uri = Uri.parse(streamUrl)
        videoView.setVideoURI(uri)
    }
}
