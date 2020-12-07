package com.bytestore.mobile_ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bytestore.mobile_ui.R
import com.bytestore.mobile_ui.ViewModelFactory
import com.bytestore.mobile_ui.mapper.ArticleUiViewMapper
import com.bytestore.mobile_ui.model.Article
import com.bytestore.presentation.model.ArticlesView
import com.bytestore.presentation.state.Resource
import com.bytestore.presentation.state.ResourceState
import com.bytestore.presentation.viewmodel.ArticlesViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.layout_fragment_news_list.*
import javax.inject.Inject

class NewsListFragment : Fragment(), ListAction {

    @Inject
    lateinit var articleUiViewMapper: ArticleUiViewMapper

    @Inject
    lateinit var viewsModelFactory: ViewModelFactory

    //TODO:Need to find a way out to inject this
    @Inject
    lateinit var articleViewModel: ArticlesViewModel


    private var rootView: View? = null
    private val adapter by lazy { NewsItemAdapter(emptyList<Article>(), this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)

        articleViewModel =
            ViewModelProvider(this, viewsModelFactory).get(ArticlesViewModel::class.java)
    }

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
        (activity!! as AppCompatActivity).setSupportActionBar(toolbar)
    }

    override fun onStart() {
        super.onStart()
        articleViewModel.liveData.observe(this, Observer {
            handleUiState(it)
        })
    }

    private fun handleUiState(resource: Resource<List<ArticlesView>>?) {
        when (resource?.status) {
            ResourceState.SUCCESS -> {
                handleSuccess(resource?.data?.map {
                    articleUiViewMapper.mapFromPresentation(it)
                })
            }

            ResourceState.ERROR -> {
                toggleListView(true)
                displaySnackbar("Something went wrong!!:${resource.message}")
            }
        }
    }

    private fun handleSuccess(articlesList: List<Article>?) {
        if (articlesList != null && articlesList.isNotEmpty()) {
            toggleListView(true)
            adapter.setData(articlesList)
        } else {
            displaySnackbar("Something went wrong!!")
        }
    }

    private fun toggleListView(shouldBeVisible: Boolean) {
        progress.isVisible = !shouldBeVisible
        newsRecyclerView.isVisible = shouldBeVisible
    }

    private fun displaySnackbar(message: String) {
        Snackbar.make(rootView!!, message, Snackbar.LENGTH_LONG).show()
    }

    override fun onClick(article: Article) {
        val action = NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment(article)
        Navigation.findNavController(rootView!!).navigate(action)
    }
}