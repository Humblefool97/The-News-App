package com.bytestore.mobile_ui.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bytestore.mobile_ui.R

class NewsDetailsFragment : Fragment() {
    private var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.layout_fragment_article_detail, container, false)
        return rootView
    }
}