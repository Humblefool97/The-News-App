package com.bytestore.remote.mapper

import com.bytestore.remote.model.ArticleModel

interface ModelMapper<M, E> {
    fun mapFromModel(M: ArticleModel): E
}