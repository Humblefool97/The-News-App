package com.bytestore.presentation.mapper

interface ViewMapper<V, D> {
    fun fromDomainToView(type: D): V
}