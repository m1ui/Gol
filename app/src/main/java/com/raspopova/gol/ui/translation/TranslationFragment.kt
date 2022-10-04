package com.raspopova.gol.ui.translation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.raspopova.gol.databinding.FragmentTranslitionBinding

class TranslationFragment : Fragment() {

    private var _binding: FragmentTranslitionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val translationViewModel =
            ViewModelProvider(this)[TranslationViewModel::class.java]

        _binding = FragmentTranslitionBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTest
        translationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}