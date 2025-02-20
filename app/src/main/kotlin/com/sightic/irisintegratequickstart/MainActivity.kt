package com.sightic.irisintegratequickstart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            SystemBarStyle.auto(
                android.graphics.Color.TRANSPARENT,
                android.graphics.Color.TRANSPARENT,
                detectDarkMode = { false },
            )
        )
        setContent {
            IRISIntegrateQuickstartTheme {
                MainScreen()
            }
        }
    }
}
