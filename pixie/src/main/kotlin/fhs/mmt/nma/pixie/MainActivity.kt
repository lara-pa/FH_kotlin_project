package fhs.mmt.nma.pixie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import fhs.mmt.nma.pixie.ui.AppNavigation
import fhs.mmt.nma.pixie.ui.theme.PixieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixieTheme(dynamicColor = false) {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
