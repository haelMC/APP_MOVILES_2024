package pe.edu.upeu.asistenciaupeujcn.modelo

data class Inscrito(
    var id: Long,
    var cui: String,
    var tipoCui: String,
    var evidensPay: String,
    var offlinex: String,
    var actividadId: String,
)