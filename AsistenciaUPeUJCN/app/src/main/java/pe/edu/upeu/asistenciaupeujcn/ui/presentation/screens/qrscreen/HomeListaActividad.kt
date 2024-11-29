package pe.edu.upeu.asistenciaupeujcn.ui.presentation.screens.qrscreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.google.gson.Gson
import pe.edu.upeu.asistenciaupeujcn.R
import pe.edu.upeu.asistenciaupeujcn.modelo.Actividad
import pe.edu.upeu.asistenciaupeujcn.ui.navigation.Destinations
import pe.edu.upeu.asistenciaupeujcn.ui.presentation.components.BottomNavigationBar
import pe.edu.upeu.asistenciaupeujcn.ui.presentation.components.LoadingCard
import pe.edu.upeu.asistenciaupeujcn.ui.presentation.components.Spacer
import pe.edu.upeu.asistenciaupeujcn.utils.TokenUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ActividadListUI(navegarListaAct: (String) -> Unit,
                    viewModel:
                    ActividadRegAsisViewModel = hiltViewModel(), navController: NavHostController
){
    val actis by
    viewModel.activ.observeAsState(arrayListOf())
    val isLoading by
    viewModel.isLoading.observeAsState(false)
    MyApp(navController, onAddClick = {
        navegarListaAct((0).toString())},
        actis,
        isLoading,
        onEditClick = {
            val jsonString = Gson().toJson(it)
            navegarListaAct(jsonString)
            TokenUtils.ID_ASIS_ACT=it.id
        }
    )
}
val formatoFecha: DateTimeFormatter? = DateTimeFormatter.ofPattern("dd-MM-yyyy")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(navController: NavHostController,
          onAddClick: (() -> Unit)? = null,
          actividades: List<Actividad>,
          isLoading: Boolean,
          onEditClick: ((toPersona: Actividad) -> Unit)? = null,
) {
    val navigationItems2 = listOf(
        Destinations.ActividadUI,
        Destinations.Pantalla1,
        Destinations.Pantalla2,
        Destinations.Pantalla3
    )
    Scaffold(
        bottomBar = {
            BottomAppBar {
                BottomNavigationBar(navigationItems2, navController =
                navController)
            }
        },
        modifier = Modifier,
    ) {
        Box(modifier = Modifier.fillMaxSize(
        )){
            LazyColumn(modifier = Modifier
                .padding(top = 80.dp, start = 16.dp, end = 16.dp, bottom = 32.dp)
                .align(alignment = Alignment.TopCenter),
                userScrollEnabled= true,
            ){
                var itemCount = actividades.size
                if (isLoading) itemCount++
                items(count = itemCount) { index ->
                    var auxIndex = index;
                    if (isLoading) {
                        if (auxIndex == 0)
                            return@items LoadingCard()
                        auxIndex--
                    }
                    val actividad = actividades[auxIndex]
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 1.dp
                        ),
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                            .fillMaxWidth(),
                    ) {
                        Row(modifier = Modifier.padding(8.dp)) {
                            Image(
                                modifier = Modifier
                                    .size(50.dp)
                                    //.clip(CircleShape)
                                    .clip(RoundedCornerShape(8.dp)),
                                painter = rememberImagePainter(
                                    data = actividad.evaluar,
                                    builder = {
                                        placeholder(R.drawable.bg)
                                        error(R.drawable.bg)
                                    }
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.FillHeight
                            )
                            Spacer()
                            Column(
                                Modifier.weight(1f),
                            ) {
                                Text("${actividad.nombreActividad} -${actividad.estado}", fontWeight = FontWeight.Bold)
                                val datex = LocalDate.parse(actividad.fecha!!,
                                    DateTimeFormatter.ISO_DATE)
                                var fecha=formatoFecha?.format(datex)
                                Text(""+fecha, color =
                                MaterialTheme.colorScheme.primary)
                            }
                            IconButton(onClick = {
                                Log.i("VERTOKEN", "Holas")
                                Log.i("VERTOKEN", TokenUtils.TOKEN_CONTENT)
                                onEditClick?.invoke(actividad)
                            }) {
                                Icon(
                                    painter = painterResource(id =
                                    R.drawable.qr),
                                    contentDescription = "QR",
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

