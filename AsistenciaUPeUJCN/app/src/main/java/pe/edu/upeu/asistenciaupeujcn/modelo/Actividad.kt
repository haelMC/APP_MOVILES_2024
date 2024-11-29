package pe.edu.upeu.asistenciaupeujcn.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actividad")
data class Actividad(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var nombreActividad: String,
    var fecha: String,
    var horai: String,
    var minToler: String,
    var latitud: String,
    var longitud: String,
    var estado: String,
    var evaluar: String,
    var userCreate: String,
    var mater: String,
    var validInsc: String,
    var asisSubact: String,
    var entsal: String,
    var offlinex: String
)

data class ActividadReport(
    var id: Long,
    var nombreActividad: String,
    var fecha: String,
    var horai: String,
    var minToler: String,
    var latitud: String,
    var longitud: String,
    var estado: String,
    var evaluar: String,
    var userCreate: String,
    var mater: String,
    var validInsc: String,
    var asisSubact: String,
    var entsal: String,
    var offlinex: String,
    var asistenciaxs: List<Asistenciax>,
    var inscritos: List<Inscrito>,
    var subactasisxs: List<Subactasisx>,
    var materialesxs: List<Materialesx>,
)
