package com.soluciones.misservicios

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soluciones.misservicios.data.models.Register
import com.soluciones.misservicios.data.models.RegisterResponse
import com.soluciones.misservicios.data.repositories.auth.AuthRepository
import com.soluciones.misservicios.viewmodel.ViewModelFactory
import com.soluciones.misservicios.viewmodel.auth.AuthViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthViewModel
    val TAG = "MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        btn_register.setOnClickListener{
            val user = Register(
                nombreUsuario = "salva.1412@gmail.com",
                password = "123456",
                auth = "manual",
                enabled = true,
                persona_id = "3"
            );
            viewModel.registerUser(user)
        }
    }

    private fun setUpViewModel(){
        viewModel = ViewModelProvider(this, ViewModelFactory(AuthRepository())).get(AuthViewModel::class.java)
        viewModel.isViewLoading.observe(this,isViewLoadingObserver)
        viewModel.onMessageError.observe(this,onMessageErrorObserver)
    }

    //observers
    private val renderLogin= Observer<RegisterResponse> {
        Log.v(TAG, "data updated $it")
    }

    private val onMessageErrorObserver= Observer<Any> {
        Log.v(TAG, "onMessageError $it")
        Toast.makeText(this, "$it", Toast.LENGTH_LONG).show()
    }

    private val isViewLoadingObserver= Observer<Boolean> {
        Log.v(TAG, "isViewLoading $it")

    }
}