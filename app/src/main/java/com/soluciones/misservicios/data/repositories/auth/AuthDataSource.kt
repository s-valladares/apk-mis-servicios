package com.soluciones.misservicios.data.repositories.auth

import com.soluciones.misservicios.data.models.Register
import com.soluciones.misservicios.data.models.RegisterResponse
import com.soluciones.misservicios.data.repositories.OperationCallBack

interface AuthDataSource {
    //fun postLogin(callback: OperationCallBack<SuccessResponse>, user: Login)
    fun postRegister(callback: OperationCallBack<RegisterResponse>, user: Register)

    fun cancel()

}