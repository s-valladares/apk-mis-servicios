package com.soluciones.misservicios.utilities.constantes

class URLs {
    companion object URLs {

        // URL DE DESARROLLO
        private const val DEV = "https://apis-mis-servicios.herokuapp.com/"

        // URL PRODUCCIÓN
        private const val PROD = "https://api.umbani.gt/prodv1.1/"

        // URL DE LA API PRINCIPAL
        const val URL_API = DEV

        // CONSTANTES PARA STORAGE DEL TOKEN
        const val DATA_TOKEN = "dataToken"
        const val TOKEN = "token"
        const val EMAIL = "email"
        const val EMAIL_RESET = "emailReset"
        const val USER_ID = "UserId"
        const val RESET_TOKEN = "reset_token"
        const val REINICIO = "reinicio"
        const val IAT = "iat"
        const val EXP = "exp"

        // CONSTASTE REGISTRO
        const val SUCCESS_REGISTER = "success"

        const val AUTH_GOOGLE = "Google"
        const val AUTH_MANUAL = "Manual"

        const val TAG = "CONSOLE"

        // Const permissions
        const val CODE_PERMISSION_GALLERY = 10001
        const val CODE_PERMISSION_CAMERA = 1002

        // Google
        const val GOOGLE_SIGN_IN = 1001

    }

}