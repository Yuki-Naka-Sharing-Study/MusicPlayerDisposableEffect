package com.example.musicplayerdisposableeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.musicplayerdisposableeffect.ui.theme.MusicPlayerDisposableEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MusicPlayerDisposableEffectTheme {
                MusicPlayerScreen()
            }
        }
    }
}
