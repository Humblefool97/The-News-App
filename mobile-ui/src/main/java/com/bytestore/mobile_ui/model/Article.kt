package com.bytestore.mobile_ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    var source: Source?,
    var author: String?,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String?,
    var publishedAt: String,
    var content: String?
) : Parcelable

@Parcelize
data class Source(
    var id: String?,
    var name: String?
) : Parcelable