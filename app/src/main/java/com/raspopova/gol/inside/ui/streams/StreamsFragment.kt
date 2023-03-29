package com.raspopova.gol.inside.ui.streams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.raspopova.gol.databinding.FragmentTranslitionBinding
import com.raspopova.gol.inside.ui.streams.data.StreamsAdapter
import kotlinx.android.synthetic.main.fragment_translition.*


class StreamsFragment : Fragment() {

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

        rv_streams.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = StreamsAdapter()
        }
    }
}
