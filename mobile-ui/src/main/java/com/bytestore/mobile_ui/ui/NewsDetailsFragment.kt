package com.bytestore.mobile_ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import com.bytestore.mobile_ui.R
import com.bytestore.mobile_ui.model.Article
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.layout_fragment_article_detail.*

class NewsDetailsFragment : Fragment() {
    private var rootView: View? = null
    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        
        TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        arguments?.let {
            article = NewsDetailsFragmentArgs.fromBundle(it).ARGARTICLE
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.layout_fragment_article_detail, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupView(article)
    }

    private fun setupView(article: Article?) {
        article?.let {
            //Add Image
            Glide.with(context)
                .load(it.urlToImage)
                .into(newsDetailImage)
            //Add date text
            dateTextView.text = it.publishedAt
            //Add Title
            titleTextView.text = it.title
            //Add content
            contentTextView.text = it.description
        }
    }

    private fun setupToolbar() {
        (activity as AppCompatActivity).setSupportActionBar(articleDetailToolbar)
    }
}