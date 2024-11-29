package pe.edu.upeu.asistenciaupeujcn.modelo

data class Materialesx(
    var id: Long,
    var cui: String,
    var tipoCui: String,
    var materEntre: String,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var modFh: String,
    var offlinex: String,
    var actividadId: Long,
)