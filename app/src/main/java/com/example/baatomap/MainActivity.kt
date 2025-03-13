package com.example.baatomap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.baatomap.UI.MapScreen
import com.example.baatomap.ui.theme.BaatoMapTheme
import org.maplibre.android.MapLibre
import org.maplibre.android.WellKnownTileServer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapLibre.getInstance(this, "bpk.qF1Ei9NBbPq-30XZOgl1uLocMkDiUEi9T4r59kGse07s", WellKnownTileServer.MapLibre)
        enableEdgeToEdge()
        setContent {
            BaatoMapTheme {
                MapScreen()
            }
        }
    }
}
