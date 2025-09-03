package io.hyemdooly.practice.doolyground.example.pagingspotify.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import io.hyemdooly.practice.doolyground.ui.theme.DoolyGroundTheme

@Composable
fun SpotifyPagingRoute(viewModel: SpotifyPagingViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.fetchAuthToken()
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Text("아 졸리당")
    }
}

@Composable
fun SpotifyPagingScreen() {

}

@Composable
@Preview
fun SpotifyPagingPreview() {
    DoolyGroundTheme {
        SpotifyPagingScreen()
    }
}
