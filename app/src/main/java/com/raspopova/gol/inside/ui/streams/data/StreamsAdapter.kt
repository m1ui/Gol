package com.raspopova.gol.inside.ui.streams.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raspopova.gol.R
import com.raspopova.gol.inside.VideoMoreActivity

@Suppress("DEPRECATION")
class StreamsAdapter: RecyclerView.Adapter<StreamsAdapter.ViewHolder>() {

    private val title = arrayOf(
        "Ювентус - Монца",
        "Байер - Боруссия Дортмунд",
        "Лацио - Фиорентина",
        "Наполи - Рома",
        "Жеребьевка группового этапа Лиги чемпионов"
    )

    private val previewImg = arrayOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five
    )

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var title: TextView
        var preview: ImageView

        init {
            title = view.findViewById(R.id.title_stream)
            preview = view.findViewById(R.id.preview_iv_stream)

            view.setOnClickListener {
                val position: Int = adapterPosition
                val context = view.context
                val intent = Intent(context, VideoMoreActivity::class.java).apply{
                    putExtra("num", position)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_translation, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = title[position]
        holder.preview.setImageResource(previewImg[position])
    }

    override fun getItemCount(): Int {
        return title.size
    }

}