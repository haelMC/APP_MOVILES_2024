package pe.edu.upeu.asistenciaupeujcn.modelo

data class Asistenciax(
    var id: Long,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var tipo: String,
    var calificacion: Long,
    var cui: String,
    var tipoCui: String,
    var entsal: String,
    var subactasisId: Long,
    var offlinex: String,
    var actividadId: Long,
){
    companion object {
        fun createEmpty(): Asistenciax {
            return Asistenciax(
                id = 0L,
                fecha = "",
                horaReg = "",
                latituda = "",
                longituda = "",
                tipo = "",
                calificacion = 0L,
                cui = "",
                tipoCui = "",
                entsal = "",
                subactasisId = 0L,
                offlinex = "",
                actividadId = 0L
            )
        }
    }
}
data class AsistenciaxResp(
    var id: Long,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var tipo: String,
    var calificacion: Long,
    var cui: String,
    var tipoCui: String,
    var entsal: String,
    var subactasisId: Long,
    var offlinex: String,
    var actividadId: Actividad,
)