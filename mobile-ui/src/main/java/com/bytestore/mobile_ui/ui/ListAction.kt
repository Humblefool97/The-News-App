package com.bytestore.mobile_ui.ui

import com.bytestore.mobile_ui.model.Article

interface ListAction {
    fun onClick(article: Article)
}