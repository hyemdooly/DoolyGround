package io.hyemdooly.practice.doolyground.example.pagingspotify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import io.hyemdooly.practice.doolyground.example.pagingspotify.ui.SpotifyPagingRoute
import io.hyemdooly.practice.doolyground.ui.theme.DoolyGroundTheme

@AndroidEntryPoint
class PagingExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DoolyGroundTheme {
                SpotifyPagingRoute()
            }
        }
    }
}
