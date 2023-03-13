package com.raspopova.gol.inside.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


class NewsViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "This is fucking Fragment"
    }
    val text: LiveData<String> = _text

    val doc: Document = Jsoup.connect("https://en.wikipedia.org/").get()
}