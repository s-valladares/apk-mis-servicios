package com.soluciones.misservicios.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soluciones.misservicios.data.repositories.auth.AuthDataSource
import com.soluciones.misservicios.viewmodel.auth.AuthViewModel

class  ViewModelFactory(private val repository: AuthDataSource): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}