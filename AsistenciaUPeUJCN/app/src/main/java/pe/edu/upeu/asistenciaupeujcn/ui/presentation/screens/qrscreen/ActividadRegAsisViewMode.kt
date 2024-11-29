package pe.edu.upeu.asistenciaupeujcn.ui.presentation.screens.qrscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pe.edu.upeu.asistenciaupeujcn.modelo.Actividad
import pe.edu.upeu.asistenciaupeujcn.repository.ActividadRepository
import javax.inject.Inject

@HiltViewModel
class ActividadRegAsisViewModel @Inject constructor(
    private val activRepo: ActividadRepository,
): ViewModel() {
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }
    val activ: LiveData<List<Actividad>> by lazy {
        activRepo.reportarActividades()
    }
    val isLoading: LiveData<Boolean> get() = _isLoading
}