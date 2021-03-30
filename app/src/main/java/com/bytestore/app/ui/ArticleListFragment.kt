package com.bytestore.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bytestore.app.Article
import com.bytestore.app.databinding.FragmentNewsListBinding
import com.bytestore.app.repository.ArticlesDataRepository
import com.bytestore.app.state.Resource
import com.bytestore.app.ui.adapter.NewsListRecyclerViewAdapters
import com.bytestore.app.viewmodel.AppViewModelFactory
import com.bytestore.app.viewmodel.ArticlesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArticleListFragment : Fragment() {
    private lateinit var fragmentBinding: FragmentNewsListBinding
    private lateinit var viewModel: ArticlesViewModel

    @Inject lateinit var adapters: NewsListRecyclerViewAdapters


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentNewsListBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(ArticlesViewModel::class.java)
        viewModel.articleLiveData.observe(viewLifecycleOwner){
           handleUi(it)
        }
        return fragmentBinding.root
    }

    private fun handleUi(resource: Resource<List<Article>>?) {

    }
}