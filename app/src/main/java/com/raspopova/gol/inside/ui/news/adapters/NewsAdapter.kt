package com.raspopova.gol.inside.ui.news.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raspopova.gol.R
import com.raspopova.gol.inside.ui.news.data.News

class NewsAdapter(private val newsList: ArrayList<News>):
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
        holder.date.text = currentItem.date.toString()
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    // ViewHolder
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage : ImageView = itemView.findViewById(R.id.news_image)
        val title : TextView = itemView.findViewById(R.id.news_title_tv)
        val description : TextView = itemView.findViewById(R.id.news_description_tv)
        val date : TextView = itemView.findViewById(R.id.news_date_tv)
    }

}