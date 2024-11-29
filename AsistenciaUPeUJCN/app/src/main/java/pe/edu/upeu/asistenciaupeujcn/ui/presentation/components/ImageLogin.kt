package pe.edu.upeu.asistenciaupeujcn.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import pe.edu.upeu.asistenciaupeujcn.R

@Composable
fun ImageLogin(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_login_image),
        contentDescription = "Image Login",
        modifier = modifier
            .fillMaxWidth()
            .size(300.dp),
        alignment = Alignment.Center
    )
}