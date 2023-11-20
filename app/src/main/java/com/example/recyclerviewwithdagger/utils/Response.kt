package com.example.recyclerviewwithmvvmdaggerproject.utils

sealed class Response<T>(private val data: T? = null, private val errormessage: String? = null) {
    class Loading<T> : Response<T>()
    class Success<T>(val data: T?) : Response<T>(data = data)
    class Error<T>(val errormessage: String) : Response<T>(errormessage = errormessage)
}
