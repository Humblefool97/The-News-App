package com.bytestore.mobile_ui.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bytestore.mobile_ui.R
import com.bytestore.mobile_ui.model.Article
import kotlinx.android.synthetic.main.layout_news_item.view.*

class NewsItemAdapter(var articlesList: List<Article>) :
    RecyclerView.Adapter<NewsItemAdapter.NewsItemViewHolder>() {


    inner class NewsItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val newsImageView: ImageView = view.newsImage
        private val newsDateText: TextView = view.dateTextView
        private val newsDescriptionText: TextView = view.descriptionTextView

        fun bind(
            newsImageUrl: String?,
            newsDate: String,
            newsDescription: String
        ) {
            //Set image using Glide
            Glide.with(view.context)
                .load(newsImageUrl)
                .into(newsImageView)
            //Set date text
            newsDateText.text = newsDate
            //Set description
            newsDescriptionText.text = newsDescription
            newsDescriptionText.isSelected = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_news_item, parent, false)
        return NewsItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val article = articlesList[position]
        holder.bind(article.urlToImage, article.publishedAt, article.description)
    }

    override fun getItemCount() = articlesList.size

    fun setData(newList: List<Article>) {
        articlesList = newList
        notifyDataSetChanged()
    }
}