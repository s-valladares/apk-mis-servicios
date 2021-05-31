package com.soluciones.misservicios.data.models

import java.io.Serializable

data class Register(
    val id: String = "",
    val nombreUsuario: String,
    val password: String,
    val enabled: Boolean,
    val persona_id: String,
    val roles: List<String> = listOf("ADMIN"),
    val auth: String
): Serializable

data class Login(
    val nombreUsuario: String,
    val password: String
)

data class Persona(
    val id: String,
    val nombres: String,
    val nombreUsuario: String,
    val apellidos: String,
    val direccion: String,
    val telefono: String
): Serializable

data class PersonaResponse(
    val success: Boolean,
    val message: String,
    val data: Int
): Serializable{
    fun isCreated(): Boolean = (success)
}

data class RegisterResponse(
    val success: Boolean,
    val message: String,
    val data: Persona
): Serializable {
    fun isCreated(): Boolean = (success)
}

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val nombreUsuario: String,
    val token: String
): Serializable {
    fun isCreated(): Boolean = (success)
}

data class ErrorResponse(
    val success: Boolean,
    val message: String,
    val errors: List<String>
): Serializable