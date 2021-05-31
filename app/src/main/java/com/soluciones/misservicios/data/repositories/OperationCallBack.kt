package com.soluciones.misservicios.data.repositories

interface OperationCallBack<T>{
    fun onSuccess(data: T?)
    fun onError(data: String?)
}