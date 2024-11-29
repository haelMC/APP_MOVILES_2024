package pe.edu.upeu.navegacionjpc

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upeu.navegacionjpc.ui.presentation.component.MyAppDrawer
import pe.edu.upeu.navegacionjpc.ui.theme.LightColorScheme
import pe.edu.upeu.navegacionjpc.ui.theme.NavegacionJPC2Theme
import pe.edu.upeu.navegacionjpc.ui.theme.ThemeType
import pe.edu.upeu.navegacionjpc.ui.theme.darkGreenScheme
import pe.edu.upeu.navegacionjpc.ui.theme.darkRedScheme
import pe.edu.upeu.navegacionjpc.ui.theme.lightGreenScheme
import pe.edu.upeu.navegacionjpc.ui.theme.lightRedScheme
import pe.edu.upeu.navegacionjpc.utils.conttexto
import pe.edu.upeu.navegacionjpc.utils.isNight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            conttexto.CONTEXTO_APPX=this
            val themeType= remember{ mutableStateOf(ThemeType.RED) }
            val darkThemex= isNight()
            val darkTheme = remember { mutableStateOf(darkThemex) }
            val colorScheme=when(themeType.value){
                ThemeType.RED->{if (darkTheme.value) darkRedScheme else
                    lightRedScheme}
                ThemeType.GREEN->{if (darkTheme.value) darkGreenScheme else
                    lightGreenScheme}
                else->{lightGreenScheme}
            }
            //conttexto.CONTEXTO_APPX=this

            NavegacionJPC2Theme(colorScheme = colorScheme) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyAppDrawer(darkMode = darkTheme, themeType =themeType )
                    //Greeting("Android")
                }



            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavegacionJPC2Theme(colorScheme =lightGreenScheme ) {
        Greeting("Android")
    }
}