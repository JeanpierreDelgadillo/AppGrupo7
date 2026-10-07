package pe.edu.cibertec.appgrupo7.response

import pe.edu.cibertec.appgrupo7.model.Usuario

data class UserResponse(
    val users: List<Usuario>
)