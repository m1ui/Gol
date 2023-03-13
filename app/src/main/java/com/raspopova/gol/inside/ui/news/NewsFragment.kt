package com.raspopova.gol.inside.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.raspopova.gol.R
import com.raspopova.gol.databinding.FragmentNewsBinding


class NewsFragment : Fragment() {

    private lateinit var linearLayout: LinearLayout
    private lateinit var btn: Button
    private lateinit var allEds: ArrayList<View>

    private var _binding: FragmentNewsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {_binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allEds = ArrayList<View>()
        linearLayout = view.findViewById(R.id.linearlayout) as LinearLayout
        btn = view.findViewById(R.id.btn) as Button

        btn.setOnClickListener{
            val btn = Button(activity)
            btn.text = "Manual Add"
            btn.layoutParams =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            linearLayout.addView(btn)
        }

    }

    private fun initData() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
