package com.raspopova.gol.ui.translation.adapters

import android.provider.MediaStore.Video
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.raspopova.gol.R
import com.raspopova.gol.ui.translation.data.Post

class LentaAdapter(private val streamList : ArrayList<Post>) : RecyclerView.Adapter<LentaAdapter.LentaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LentaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_translation_item, parent, false)
        return LentaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LentaViewHolder, position: Int) {
        val currentItem = streamList[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
    }

    override fun getItemCount(): Int {
        return streamList.size
    }

    class LentaViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.item_title_translation)
        //val video : VideoView = itemView.findViewById(R.id.item_video)
        val description : TextView = itemView.findViewById(R.id.item_description_translation)
    }
}