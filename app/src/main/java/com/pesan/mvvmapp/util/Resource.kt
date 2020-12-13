package com.pesan.mvvmapp.util

sealed class Resource<T> (
    val data: T? = null,
    val messange: String? = null

){
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(messange: String?, data: T? = null): Resource<T>(data, messange)
    class Loading<T>: Resource<T>()

}