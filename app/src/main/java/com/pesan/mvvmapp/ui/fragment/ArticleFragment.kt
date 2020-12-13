package com.pesan.mvvmapp.ui.fragment

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.pesan.mvvmapp.ui.MainActivity
import com.pesan.mvvmapp.ui.NewsViewModel
import com.google.android.material.snackbar.Snackbar
import com.pesan.mvvmapp.R
import kotlinx.android.synthetic.main.fragment_article.*


class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webview.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)

        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Artikel berhasil disave", Snackbar.LENGTH_SHORT).show()
        }
    }
}