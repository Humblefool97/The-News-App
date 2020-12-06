package com.bytestore.mobile_ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bytestore.mobile_ui.R
import com.bytestore.mobile_ui.model.Article
import kotlinx.android.synthetic.main.layout_fragment_news_list.*

class NewsListFragment : Fragment() {

    private var rootView: View? = null
    private val adapter by lazy { NewsItemAdapter(emptyList<Article>()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.layout_fragment_news_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(newsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@NewsListFragment.adapter
        }
    }

    companion object {
        fun startNewsLisFragment(
            containerId: Int,
            fragmentManager: FragmentManager
        ): NewsListFragment {
            val instance = NewsListFragment()
            fragmentManager.beginTransaction().replace(containerId, instance)
            return instance
        }
    }
}