package pe.edu.upeu.asistenciaupeujcn.modelo

data class Usuario(
    val nombres: String,
    val apellidos: String,
    val correo: String,
    val password: String,
    val token: String,
    val dni: String,
    val perfilPrin: String,
    val estado: String,
    val offlinex: String,
)
data class UsuarioDto(
    var correo: String,
    var password: String,
)

data class UsuarioResp(
    val id: Long,
    val nombres: String,
    val apellidos: String,
    val correo: String,
    val token: String,
    val dni: String,
    val perfilPrin: String,
    val estado: String,val offlinex: String,
)
