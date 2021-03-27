package com.bytestore.app.state

class Resource<T> constructor(
    val state: ResourceState,
    val data: T?,
    val message: String?
)