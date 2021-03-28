package com.bytestore.app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bytestore.app.databinding.FragmentNewsListBinding
import com.bytestore.app.repository.ArticlesDataRepository
import com.bytestore.app.viewmodel.AppViewModelFactory
import com.bytestore.app.viewmodel.ArticlesViewModel

class ArticleListFragment : Fragment() {
    private lateinit var fragmentBinding: FragmentNewsListBinding
    private lateinit var viewModel: ArticlesViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentNewsListBinding.inflate(inflater)

        return fragmentBinding.root
    }
}