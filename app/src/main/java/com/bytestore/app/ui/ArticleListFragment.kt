package com.bytestore.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.bytestore.app.Article
import com.bytestore.app.databinding.FragmentNewsListBinding
import com.bytestore.app.state.Resource
import com.bytestore.app.state.ResourceState
import com.bytestore.app.ui.adapter.NewsListRecyclerViewAdapters
import com.bytestore.app.viewmodel.ArticlesViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class ArticleListFragment : Fragment() {
    private lateinit var fragmentBinding: FragmentNewsListBinding
    private lateinit var viewModel: ArticlesViewModel

    @Inject
    lateinit var adapters: NewsListRecyclerViewAdapters
    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentNewsListBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(ArticlesViewModel::class.java)

        viewModel.articleLiveData.observe(viewLifecycleOwner) {
            coroutineScope.launch {
                handleUi(it)
            }

        }
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(fragmentBinding) {
            articleListView.adapter = adapters
            articleListView.layoutManager = LinearLayoutManager(context)
        }
    }

    private suspend fun handleUi(resource: Resource<PagingData<Article>>) =
        withContext(Dispatchers.Main.immediate) {
            when (resource?.state) {
                ResourceState.LOADING -> fragmentBinding.progressIndicatorLayout.progressLayout.isVisible =
                    true
                ResourceState.SUCCESS -> {
                    fragmentBinding.progressIndicatorLayout.progressLayout.isVisible =
                        false
                    val data = resource.data as PagingData<Article>
                    adapters.submitData(data)
                }
                ResourceState.ERROR -> {
                    fragmentBinding.progressIndicatorLayout.progressLayout.isVisible =
                        false
                    resource.message?.let {
                        Snackbar.make(fragmentBinding.root, it, Snackbar.LENGTH_LONG).show()
                    }

                }
            }
        }
}