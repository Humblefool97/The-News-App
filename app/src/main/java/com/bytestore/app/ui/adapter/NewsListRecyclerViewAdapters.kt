package com.bytestore.app.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bytestore.app.Article
import com.bytestore.app.R
import com.bytestore.app.databinding.LayoutItemListBinding

class NewsListRecyclerViewAdapters : PagingDataAdapter<Article, NewsListRecyclerViewAdapters.NewListViewHolder>(ARTICLE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewListViewHolder {
        val viewBinding = LayoutItemListBinding.inflate(LayoutInflater.from(parent.context))
        return NewListViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: NewListViewHolder, position: Int) {

        val article = getItem(position)
        article?.let { article ->
            holder.bind(article)
        }

    }

    companion object {
        val ARTICLE_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class NewListViewHolder(val viewBinding: LayoutItemListBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        val imageView = viewBinding.articleImageView
        val dateTextView = viewBinding.articleDateTextView
        val titleTextView = viewBinding.titleTextView
        val desciptionTextView = viewBinding.descriptionTextView

        fun bind(article: Article) {
            with(article) {
                Glide.with(viewBinding.root).load(urlToImage).into(imageView)
                dateTextView.text = publishedAt ?: "-"
                titleTextView.text = title ?: "-"
                desciptionTextView.text = description ?: "-"
            }
        }
    }
}