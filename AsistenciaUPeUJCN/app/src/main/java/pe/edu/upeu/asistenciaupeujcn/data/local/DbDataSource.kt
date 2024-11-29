package pe.edu.upeu.asistenciaupeujcn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.edu.upeu.asistenciaupeujcn.data.local.dao.ActividadDao
import pe.edu.upeu.asistenciaupeujcn.modelo.Actividad
import pe.edu.upeu.asistenciaupeujcn.modelo.Materialesx

@Database(entities = [Actividad::class], version = 1)
abstract class DbDataSource: RoomDatabase() {
    abstract fun actividadDao():ActividadDao
}