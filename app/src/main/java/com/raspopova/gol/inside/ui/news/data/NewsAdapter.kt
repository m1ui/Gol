package com.raspopova.gol.inside.ui.news.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raspopova.gol.R

@Suppress("DEPRECATION")
class NewsAdapter: RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    // Data

    private val title = arrayOf(
        "«Реал» отказался от идеи подписания Мбаппе",
        "Бразилия не смогла подтвердить статус главного фаворита чемпионата мира",
        "Испания покинула чемпионат мира с антирекордом турнира",
        "Германия во второй раз кряду может остаться без плей-офф на футбольном ЧМ",
        "Стало известно, во сколько Катару обошелся футбольный чемпионат мира",
        "Массимо Каррера: Чемпионом РПЛ станет «Зенит» или Спартак",
        "Топ-5 футбольных звезд, которые пропустят ЧМ-2022 из-за травм",
        "Агент Александра Головина намекнул на возможный переход игрока в более сильный клуб Европы")

    private val description = arrayOf(
        "Мадридский футбольный клуб «Реал» не собирается подписывать звездного нападающего ПСЖ и сборной Франции Килиана Мбаппе любой ценой.",
        "Сборная Бразилии по футболу не оправдала выданные ею авансы как главному фавориту чемпионата мира в Катаре.",
        "Сборная Испании по футболу неожиданно рано завершила свой путь на чемпионате мира в Катаре, споткнувшись о первого же соперника по плей-офф.",
        "Сборная Германии по футболу близка к историческому антирекорду на чемпионате мира в Катаре.",
        "В Катаре стартовало главное футбольное событие четырехлетки – чемпионат мира с участием 32-х лучших команд со всех уголков планеты.",
        "Несмотря на внушительное преимущество «Зенита» над своими конкурентами по итогам первой половины чемпионата, многие спортивные аналитики продолжают развивать тему борьбы за чемпионство.",
        "Совсем скоро в Катаре стартует главное футбольное событие четырехлетия – чемпионат мира, но не все его главные звезды смогут порадовать фанатов своей игрой.",
        "Александр Головин стал одним из немногих российских игроков в последнее время, кто смог полностью адаптироваться в Европе.")

    private val date = arrayOf(
        "2022-12-26",
        "2022-12-12",
        "2022-12-07",
        "2022-11-28",
        "2022-11-21",
        "2022-11-11",
        "2022-11-09",
        "2022-11-09")

    private val licked = arrayOf(false,
        true, false, false,
        false, false, false,
        false)

    // inner ViewHolder
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var title: TextView
        var description: TextView
        var isLiked: ImageView
        var date: TextView

        init {

            title = view.findViewById(R.id.title_news)
            description = view.findViewById(R.id.description_news)
            isLiked = view.findViewById(R.id.like_news)
            date = view.findViewById(R.id.date_news)

            view.setOnClickListener {
                var position: Int = adapterPosition
                val context = view.context
                /* val intent = Intent(context, DetailsNewsActivity::class.java).apply{

                    putExtra("NUMBER", position)
                    putExtra("CODE", itemKode.text)
                    putExtra("CATEGORY", itemKategori.text)
                    putExtra("CONTENT", itemIsi.text)

                } */
                // context.startActivity(intent)
            }
            isLiked.setOnClickListener {
                val position: Int = adapterPosition
                if (licked[position]) {
                    isLiked.setImageResource(R.drawable.ic_football_heart)
                    licked[position] = false
                } else {
                    isLiked.setImageResource(R.drawable.ic_football_heart_red)
                    licked[position] = true
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news_layout, parent, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = title[position]
        holder.description.text = description[position]
        holder.date.text = date[position]
        if (licked[position]) {
            holder.isLiked.setImageResource(R.drawable.ic_football_heart_red)
        } else {
            holder.isLiked.setImageResource(R.drawable.ic_football_heart)
        }

    }

    override fun getItemCount(): Int {
        return title.size
    }
}