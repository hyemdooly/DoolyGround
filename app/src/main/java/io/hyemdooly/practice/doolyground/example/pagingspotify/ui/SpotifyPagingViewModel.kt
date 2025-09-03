package io.hyemdooly.practice.doolyground.example.pagingspotify.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.datasource.AuthDataSource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpotifyPagingViewModel @Inject constructor(private val authRepository: AuthDataSource) :
    ViewModel() {
    fun fetchAuthToken() {
        viewModelScope.launch {
            runCatching {
                authRepository.getToken()
            }.onSuccess {
                Log.d("Token", it)
            }.onFailure {
                Log.e("Token", it.message.toString())
            }
        }
    }
}
