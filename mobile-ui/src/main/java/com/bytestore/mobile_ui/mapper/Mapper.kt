package com.bytestore.mobile_ui.mapper

interface Mapper<P, V> {
    fun mapFromPresentation(presentation: P): V
}