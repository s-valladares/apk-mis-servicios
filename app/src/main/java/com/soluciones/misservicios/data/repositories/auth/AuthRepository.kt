package com.soluciones.misservicios.data.repositories.auth

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.soluciones.misservicios.data.models.ErrorResponse
import com.soluciones.misservicios.data.models.Register
import com.soluciones.misservicios.data.models.RegisterResponse
import com.soluciones.misservicios.data.repositories.OperationCallBack
import com.soluciones.misservicios.data.services.authservices.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response


class AuthRepository: AuthDataSource {

    private var call: Call<RegisterResponse>?=null
    private val TAG = "AUTHREPOSITORY"

    // Repository para registarse --> register
    override fun postRegister(callback: OperationCallBack<RegisterResponse>, user: Register) {
        call = AuthService.build()?.register(user)
        call?.enqueue(object :Callback<RegisterResponse>{

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {

                Log.v(TAG, "Error ${t.message}")
                callback.onError(t.message)
            }
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {

                if(!response.isSuccessful) {
                    val gSon = Gson()
                    val type = object : TypeToken<ErrorResponse>() {}.type
                    val errorResponse: ErrorResponse? = gSon.fromJson(response.errorBody()?.charStream(), type)

                    Log.v(TAG, "Message: ${errorResponse?.message}")
                    Log.v(TAG, "Success: ${errorResponse?.success}")
                    Log.v(TAG, "Errors: ")
                    for (i in errorResponse?.errors!!){
                        Log.v(TAG, i)
                    }
                    callback.onError(errorResponse?.message)
                }

                response.body()?.let {

                    val gson = Gson()
                    val json = gson.toJson(it)
                    val jsonIngreso = gson.toJson(user)

                    Log.v(TAG, "objeto registro mio $jsonIngreso")
                    Log.v(TAG, "data completo $json")
                    Log.v(TAG, "data ${it.data}")

                    if(!it.isCreated()){
                        Log.v(TAG, "data success false ${it.success}")
                        val gon = Gson()
                        val json = gson.toJson(it)
                        val jsonIngreso = gson.toJson(user)
                    }

                    if(response.isSuccessful && (it.isCreated())){
                        Log.v(TAG, "data success true ${it.data}")
                        callback.onSuccess(it)
                    }else{

                        callback.onError(it.message)
                        callback.onSuccess(it)
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.let {
            it.cancel()
        }
    }
}