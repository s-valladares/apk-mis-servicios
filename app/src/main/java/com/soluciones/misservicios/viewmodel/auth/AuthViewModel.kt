package com.soluciones.misservicios.viewmodel.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.soluciones.misservicios.data.models.Register
import com.soluciones.misservicios.data.models.RegisterResponse
import com.soluciones.misservicios.data.repositories.OperationCallBack
import com.soluciones.misservicios.data.repositories.auth.AuthDataSource

class AuthViewModel(private val repository: AuthDataSource): ViewModel() {

    enum class AuthenticationState {
        UNAUTHENTICATED,        // Initial state, the user needs to authenticate
        AUTHENTICATED  ,        // The user has authenticated successfully
        INVALID_AUTHENTICATION  // Authentication failed
    }

    val authenticationState = MutableLiveData<AuthenticationState>()

    init {
        // In this example, the user is always unauthenticated when MainActivity is launched
        authenticationState.value = AuthenticationState.UNAUTHENTICATED

    }

    private val _isViewLoading= MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError= MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList= MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList
/*
    fun loginEmailAndPass(user: Login){
        _isViewLoading.postValue(true)
        repository.postLogin(object :
            OperationCallBack<SuccessResponse> {
            override fun onError(error: String?) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue( error)
                authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
            }

            override fun onSuccess(data: SuccessResponse?) {
                _isViewLoading.postValue(false)
                Log.v("AUTHVIEWMODEL", "Token: ${data!!.token}")
                decodeToken(data)

            }
        }, user)
    }
*/
    fun registerUser(user: Register){
        _isViewLoading.postValue(true)
        repository.postRegister(object :
            OperationCallBack<RegisterResponse> {
            override fun onError(error: String?) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(error)
                //authenticationState.value = AuthenticationState.INVALID_AUTHENTICATION
            }
            override fun onSuccess(data: RegisterResponse?) {
                _isViewLoading.postValue(false)

            }
        }, user)
    }



}