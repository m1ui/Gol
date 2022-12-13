package com.raspopova.gol.ui.translation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raspopova.gol.R
import com.raspopova.gol.databinding.FragmentTranslitionBinding
import com.raspopova.gol.ui.translation.adapters.LentaAdapter
import com.raspopova.gol.ui.translation.data.Post

class TranslationFragment : Fragment() {

    private var _binding: FragmentTranslitionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: LentaAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var streamList: ArrayList<Post>

    lateinit var title: Array<String>
    lateinit var description: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTranslitionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView_translation)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = LentaAdapter(streamList)
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(){
        streamList = arrayListOf<Post>()

        title = arrayOf(
        getString(R.string.title1),
        getString(R.string.title2),
        getString(R.string.title3),
        getString(R.string.title4),
        getString(R.string.title5),
        getString(R.string.title6),
        getString(R.string.title7),
        getString(R.string.title8),
        getString(R.string.title9),
        getString(R.string.title10)
        )

        description = arrayOf(
            getString(R.string.title1),
            getString(R.string.title2),
            getString(R.string.title3),
            getString(R.string.title4),
            getString(R.string.title5),
            getString(R.string.title6),
            getString(R.string.title7),
            getString(R.string.title8),
            getString(R.string.title9),
            getString(R.string.title10)
        )

        for (i in title.indices) {

            val stream = Post(title[i], description[i])
            streamList.add(stream)
        }
    }
}