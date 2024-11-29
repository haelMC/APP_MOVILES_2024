package pe.edu.upeu.asistenciaupeujcn.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujcn.data.remote.RestAsistenciax
import pe.edu.upeu.asistenciaupeujcn.modelo.Asistenciax
import pe.edu.upeu.asistenciaupeujcn.utils.TokenUtils
import pe.edu.upeu.asistenciaupeujcn.utils.isNetworkAvailable
import javax.inject.Inject

interface AsistenciaxRepository {
    suspend fun deleteAsistenciax(asistenciax: Asistenciax)
    fun reportarAsistenciax(): LiveData<List<Asistenciax>>
    fun buscarAsistenciaxId(id:Long): LiveData<Asistenciax>
    suspend fun insertarAsistenciax(asistenciax: Asistenciax):Boolean
    suspend fun modificarAsistenciax(asistenciax:Asistenciax):Boolean
}
class AsistenciaxRepositoryImp @Inject constructor(
    private val restAsistenciax: RestAsistenciax,
    //private val asistenciaxDao: AsistenciaxDao,
): AsistenciaxRepository{
    override suspend fun deleteAsistenciax(asistenciax: Asistenciax) {
        CoroutineScope(Dispatchers.IO).launch {

            restAsistenciax.deleteAsistenciax(TokenUtils.TOKEN_CONTENT,asistenciax.id
            )
        }
    }
    override fun reportarAsistenciax(): LiveData<List<Asistenciax>> {
        lateinit var data: List<Asistenciax>
        val _asistenciaListLiveData =
            MutableLiveData<List<Asistenciax>>()
        val asistenciaListLiveData: LiveData<List<Asistenciax>> =
            _asistenciaListLiveData
        try {
            CoroutineScope(Dispatchers.IO).launch{
                delay(3000)
                if (isNetworkAvailable(TokenUtils.CONTEXTO_APPX)){
                    data=restAsistenciax.reportarAsistenciax(TokenUtils.TOKEN_CONTENT).body()!!
                    data?.let { _asistenciaListLiveData.postValue(it)
                    }
                }
            }
        }catch (e:Exception){
            Log.i("ERROR", "Error: ${e.message}")
        }
        return asistenciaListLiveData
    }
    override fun buscarAsistenciaxId(id: Long): LiveData<Asistenciax> {
        lateinit var data: Asistenciax
        val _asistenciaLiveData = MutableLiveData<Asistenciax>()
        val asistenciaListLiveData: LiveData<Asistenciax> =
            _asistenciaLiveData
        try {
            CoroutineScope(Dispatchers.IO).launch{
                delay(3000)
                if (isNetworkAvailable(TokenUtils.CONTEXTO_APPX)){

                    data=restAsistenciax.getAsistenciaxId(TokenUtils.TOKEN_CONTENT,
                        id).body()!!
                    data?.let {
                        _asistenciaLiveData.postValue(it)
                    }
                }
            }
        }catch (e:Exception){
            Log.i("ERROR", "Error: ${e.message}")
        }
        return asistenciaListLiveData
    }
    override suspend fun insertarAsistenciax(asistenciax: Asistenciax):
            Boolean {
        return restAsistenciax.insertarAsistenciax(TokenUtils.TOKEN_CONTENT,asistenciax)
            .body()!=null
    }
    override suspend fun modificarAsistenciax(asistenciax: Asistenciax):
            Boolean {
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("VER", TokenUtils.TOKEN_CONTENT)
        }
        return restAsistenciax.actualizarAsistenciax(TokenUtils.TOKEN_CONTENT,
            asistenciax.id,
            asistenciax).body()!=null
    }
}
