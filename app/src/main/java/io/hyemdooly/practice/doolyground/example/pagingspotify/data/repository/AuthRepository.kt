package io.hyemdooly.practice.doolyground.example.pagingspotify.data.repository

import io.hyemdooly.practice.doolyground.BuildConfig
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.SpotifyAuthService
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.model.SpotifyTokenResponse
import okhttp3.Credentials
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val service: SpotifyAuthService,
) : AuthRepository {
    override suspend fun getToken(): SpotifyTokenResponse =
        service.getAccessToken(
            authorization = Credentials.basic(BuildConfig.ID_SPOTIFY, BuildConfig.SECRET_SPOTIFY),
            grantType = "client_credentials",
        )
}


interface AuthRepository {
    suspend fun getToken(): SpotifyTokenResponse
}
