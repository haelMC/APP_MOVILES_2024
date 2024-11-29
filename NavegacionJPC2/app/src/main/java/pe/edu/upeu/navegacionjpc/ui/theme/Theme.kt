package pe.edu.upeu.navegacionjpc.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

public val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

public val lightRedScheme = lightColorScheme(
    primary = red_primaryLight,
    onPrimary = red_onPrimaryLight,
    primaryContainer = red_primaryContainerLight,
    onPrimaryContainer = red_onPrimaryContainerLight,
    secondary = red_secondaryLight,
    onSecondary = red_onSecondaryLight,
    secondaryContainer = red_secondaryContainerLight,
    onSecondaryContainer = red_onSecondaryContainerLight,
    tertiary = red_tertiaryLight,
    onTertiary = red_onTertiaryLight,
    tertiaryContainer = red_tertiaryContainerLight,
    onTertiaryContainer = red_onTertiaryContainerLight,
    error = red_errorLight,
    onError = red_onErrorLight,
    errorContainer = red_errorContainerLight,
    onErrorContainer = red_onErrorContainerLight,
    background = red_backgroundLight,
    onBackground = red_onBackgroundLight,
    surface = red_surfaceLight,
    onSurface = red_onSurfaceLight,
    surfaceVariant = red_surfaceVariantLight,
    onSurfaceVariant = red_onSurfaceVariantLight,
    outline = red_outlineLight,
    outlineVariant = red_outlineVariantLight,
    scrim = red_scrimLight,
    inverseSurface = red_inverseSurfaceLight,
    inverseOnSurface = red_inverseOnSurfaceLight,
    inversePrimary = red_inversePrimaryLight,

)

public val darkRedScheme = darkColorScheme(
    primary = red_primaryDark,
    onPrimary = red_onPrimaryDark,
    primaryContainer = red_primaryContainerDark,
    onPrimaryContainer = red_onPrimaryContainerDark,
    secondary = red_secondaryDark,
    onSecondary = red_onSecondaryDark,
    secondaryContainer = red_secondaryContainerDark,
    onSecondaryContainer = red_onSecondaryContainerDark,
    tertiary = red_tertiaryDark,
    onTertiary = red_onTertiaryDark,
    tertiaryContainer = red_tertiaryContainerDark,
    onTertiaryContainer = red_onTertiaryContainerDark,
    error = red_errorDark,
    onError = red_onErrorDark,
    errorContainer = red_errorContainerDark,
    onErrorContainer = red_onErrorContainerDark,
    background = red_backgroundDark,
    onBackground = red_onBackgroundDark,
    surface = red_surfaceDark,
    onSurface = red_onSurfaceDark,
    surfaceVariant = red_surfaceVariantDark,
    onSurfaceVariant = red_onSurfaceVariantDark,
    outline = red_outlineDark,
    outlineVariant = red_outlineVariantDark,
    scrim = red_scrimDark,
    inverseSurface = red_inverseSurfaceDark,
    inverseOnSurface = red_inverseOnSurfaceDark,
    inversePrimary = red_inversePrimaryDark,

)

public val lightGreenScheme = lightColorScheme(
    primary = green_primaryLight,
    onPrimary = green_onPrimaryLight,
    primaryContainer = green_primaryContainerLight,
    onPrimaryContainer = green_onPrimaryContainerLight,
    secondary = green_secondaryLight,
    onSecondary = green_onSecondaryLight,
    secondaryContainer = green_secondaryContainerLight,
    onSecondaryContainer = green_onSecondaryContainerLight,
    tertiary = green_tertiaryLight,
    onTertiary = green_onTertiaryLight,
    tertiaryContainer = green_tertiaryContainerLight,
    onTertiaryContainer = green_onTertiaryContainerLight,
    error = green_errorLight,
    onError = green_onErrorLight,
    errorContainer = green_errorContainerLight,
    onErrorContainer = green_onErrorContainerLight,
    background = green_backgroundLight,
    onBackground = green_onBackgroundLight,
    surface = green_surfaceLight,
    onSurface = green_onSurfaceLight,
    surfaceVariant = green_surfaceVariantLight,
    onSurfaceVariant = green_onSurfaceVariantLight,
    outline = green_outlineLight,
    outlineVariant = green_outlineVariantLight,
    scrim = green_scrimLight,
    inverseSurface = green_inverseSurfaceLight,
    inverseOnSurface = green_inverseOnSurfaceLight,
    inversePrimary = green_inversePrimaryLight,
)

public val darkGreenScheme = darkColorScheme(
    primary = green_primaryDark,
    onPrimary = green_onPrimaryDark,
    primaryContainer = green_primaryContainerDark,
    onPrimaryContainer = green_onPrimaryContainerDark,
    secondary = green_secondaryDark,
    onSecondary = green_onSecondaryDark,
    secondaryContainer = green_secondaryContainerDark,
    onSecondaryContainer = green_onSecondaryContainerDark,
    tertiary = green_tertiaryDark,
    onTertiary = green_onTertiaryDark,
    tertiaryContainer = green_tertiaryContainerDark,
    onTertiaryContainer = green_onTertiaryContainerDark,
    error = green_errorDark,
    onError = green_onErrorDark,
    errorContainer = green_errorContainerDark,
    onErrorContainer = green_onErrorContainerDark,
    background = green_backgroundDark,
    onBackground = green_onBackgroundDark,
    surface = green_surfaceDark,
    onSurface = green_onSurfaceDark,
    surfaceVariant = green_surfaceVariantDark,
    onSurfaceVariant = green_onSurfaceVariantDark,
    outline = green_outlineDark,
    outlineVariant = green_outlineVariantDark,
    scrim = green_scrimDark,
    inverseSurface = green_inverseSurfaceDark,
    inverseOnSurface = green_inverseOnSurfaceDark,
    inversePrimary = green_inversePrimaryDark,
)

enum class ThemeType{RED, GREEN}

@Composable
fun NavegacionJPC2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    colorScheme: ColorScheme,
    content: @Composable () -> Unit
) {
    /*val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}