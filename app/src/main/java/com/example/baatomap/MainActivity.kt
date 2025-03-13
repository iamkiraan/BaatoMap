package com.example.baatomap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.baatomap.UI.MapScreen
import com.example.baatomap.UI.MapView
import com.example.baatomap.ui.theme.BaatoMapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaatoMapTheme {
                MapView()
            }
        }
    }
}
