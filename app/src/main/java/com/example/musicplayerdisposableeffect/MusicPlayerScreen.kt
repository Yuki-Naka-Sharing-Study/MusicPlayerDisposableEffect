package com.example.musicplayerdisposableeffect

import android.media.MediaPlayer
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MusicPlayerScreen() {
    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }

    var mediaPlayer: MediaPlayer? = null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isPlaying) "再生中 🎶" else "停止中 ⏹",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            isPlaying = !isPlaying
        }) {
            Text(if (isPlaying) "停止する" else "再生する")
        }
    }

    // DisposableEffect：再生状態の開始と終了を管理
    if (isPlaying) {
        DisposableEffect(Unit) {
            mediaPlayer = MediaPlayer.create(context, R.raw.sample_music)
            mediaPlayer?.start()

            onDispose {
                mediaPlayer?.apply {
                    stop()
                    release()
                }
                mediaPlayer = null
                Log.d("MusicPlayer", "🎵 音楽停止・解放")
            }
        }
    }
}
