package com.cpx_research.interfaces

interface OnCPXResponseListener<T> {

    fun onSuccess(data: T?)

    fun onError(message: String)

}