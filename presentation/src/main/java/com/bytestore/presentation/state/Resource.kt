package com.bytestore.presentation.state

class Resource<T> constructor(
    val status: ResourceState,
    val data: T?,
    val message: String?
)