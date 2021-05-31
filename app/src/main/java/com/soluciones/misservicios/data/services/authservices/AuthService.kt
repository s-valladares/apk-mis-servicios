package com.soluciones.misservicios.data.services.authservices

import com.soluciones.misservicios.data.models.*
import com.soluciones.misservicios.utilities.constantes.URLs
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

object AuthService {

    private var serviceAuth: AuthEndPoints?=null

    fun build(): AuthEndPoints?{
        val builder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(URLs.URL_API)
            .addConverterFactory(GsonConverterFactory.create())

        val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor())

        val retrofit: Retrofit = builder.client(httpClient.build()).build()
        serviceAuth = retrofit.create(
            AuthEndPoints::class.java)

        return serviceAuth as AuthEndPoints
    }

    private fun interceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    interface AuthEndPoints {
        @POST("auth/login/")
        fun login(@Body userLogin: Login): Call<LoginResponse>

        @POST("auth/nuevo/")
        fun register(@Body userRegister: Register): Call<RegisterResponse>

    }
}