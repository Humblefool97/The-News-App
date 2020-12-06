package com.bytestore.domain.interactor

import com.bytestore.domain.repository.ArticlesRepository
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    val articlesRepository: ArticlesRepository
) {
    suspend operator fun invoke() = articlesRepository.getArticles()
}