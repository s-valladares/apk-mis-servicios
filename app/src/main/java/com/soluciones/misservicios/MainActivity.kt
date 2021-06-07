package com.soluciones.misservicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.soluciones.misservicios.data.models.Register
import com.soluciones.misservicios.data.models.RegisterResponse
import com.soluciones.misservicios.data.repositories.auth.AuthRepository
import com.soluciones.misservicios.databinding.ActivityMainBinding
import com.soluciones.misservicios.viewmodel.ViewModelFactory
import com.soluciones.misservicios.viewmodel.auth.AuthViewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.soluciones.misservicios.utilities.constantes.TAGs

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AuthViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view  = binding.root

        setContentView(view)

        setUpViewModel()
        setUI()



    }

    private fun setUpViewModel(){
        viewModel = ViewModelProvider(this, ViewModelFactory(AuthRepository())).get(AuthViewModel::class.java)
        viewModel.isViewLoading.observe(this,isViewLoadingObserver)
        viewModel.onMessageError.observe(this,onMessageErrorObserver)
    }

    //observers
    private val renderLogin= Observer<RegisterResponse> {
        Log.v(TAGs.MAIN, "data updated $it")
    }

    private val onMessageErrorObserver= Observer<Any> {
        Log.v(TAGs.MAIN, "onMessageError $it")
        Toast.makeText(this, "$it", Toast.LENGTH_LONG).show()
    }

    private val isViewLoadingObserver= Observer<Boolean> {
        Log.v(TAGs.MAIN, "isViewLoading $it")

    }

    private fun setUI(){



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
}