package com.raspopova.gol.inside.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.raspopova.gol.data.Consts.Companion.URL_FOOTBALL_NEWS
import com.raspopova.gol.databinding.FragmentNewsBinding
import org.jsoup.Jsoup


class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = FragmentNewsBinding.inflate(inflater, container, false)

        val textView: TextView = binding.textHome

        val doc = Jsoup.parse(URL_FOOTBALL_NEWS)
        textView.text = doc.html()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}