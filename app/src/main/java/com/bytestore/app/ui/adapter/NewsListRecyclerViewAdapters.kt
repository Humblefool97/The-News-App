package com.bytestore.app.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bytestore.app.Article
import com.bytestore.app.R
import com.bytestore.app.databinding.LayoutItemListBinding

class NewsListRecyclerViewAdapters(
    var articleList: List<Article>
) : RecyclerView.Adapter<NewsListRecyclerViewAdapters.NewListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewListViewHolder {
        val viewBinding = LayoutItemListBinding.inflate(LayoutInflater.from(parent.context))
        return NewListViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: NewListViewHolder, position: Int) {
        val article = articleList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int = articleList.size

    fun submitItems(list: List<Article>) {
        articleList = list
        notifyDataSetChanged()
    }

    inner class NewListViewHolder(val viewBinding: LayoutItemListBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        val imageView = viewBinding.articleImageView
        val dateTextView = viewBinding.articleDateTextView
        val titleTextView = viewBinding.titleTextView
        val desciptionTextView = viewBinding.descriptionTextView

        fun bind(article: Article) {
            with(article) {
                //TODO:Set image
                Glide.with(viewBinding.root).load(urlToImage).into(imageView)
                dateTextView.text = publishedAt ?: "-"
                titleTextView.text = title ?: "-"
                desciptionTextView.text = description ?: "-"
            }
        }
    }
}