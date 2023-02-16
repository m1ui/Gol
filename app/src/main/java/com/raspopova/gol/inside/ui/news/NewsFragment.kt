package com.raspopova.gol.inside.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raspopova.gol.R
import com.raspopova.gol.databinding.FragmentNewsBinding
import com.raspopova.gol.inside.ui.news.adapters.NewsAdapter
import com.raspopova.gol.inside.ui.news.data.News
import java.util.*

class NewsFragment : Fragment() {

    private lateinit var adapter: NewsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    lateinit var imageId: Array<Int>
    lateinit var titles: Array<String>
    lateinit var descriptions: Array<String>
    lateinit var dates: Array<Date>

    private var _binding: FragmentNewsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = FragmentNewsBinding.inflate(inflater, container, false)

        initData()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = binding.root.findViewById(R.id.news_recyclerview)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = NewsAdapter(newsArrayList)
        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initData() {
        newsArrayList = arrayListOf<News>()

        imageId = arrayOf(
            R.drawable.ic_person_24,
            R.drawable.ic_ball,
            R.drawable.ic_home_black_24dp
        )

        titles = arrayOf(
            getString(R.string.app_name),
            getString(R.string.google_app_id),
            getString(R.string.title1)
        )

        descriptions = arrayOf(
            getString(R.string.app_name),
            getString(R.string.app_name),
            getString(R.string.app_name)
        )

        dates = arrayOf(
            Date(),
            Date(),
            Date()
        )

        for (i in imageId.indices){
            val news = News(imageId[i], titles[i], descriptions[i], dates[i])
            newsArrayList.add(news)
        }
    }

}