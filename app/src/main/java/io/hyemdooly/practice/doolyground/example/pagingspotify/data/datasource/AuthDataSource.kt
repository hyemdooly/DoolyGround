package io.hyemdooly.practice.doolyground.example.pagingspotify.data.datasource

import io.hyemdooly.practice.doolyground.BuildConfig
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.SpotifyAuthService
import okhttp3.Credentials
import javax.inject.Inject

interface AuthDataSource {
    suspend fun getToken(): String
}

class AuthDataSourceImpl @Inject constructor(
    private val service: SpotifyAuthService,
) : AuthDataSource {
    // 해당 예제에서는 토큰이 만료되어 재발급 받는 경우는 아직 구현되지 않음
    private var token = ""

    override suspend fun getToken(): String {
        if (token.isEmpty()) {
            token = service.getAccessToken(
                authorization = Credentials.basic(
                    BuildConfig.ID_SPOTIFY,
                    BuildConfig.SECRET_SPOTIFY
                ),
                grantType = "client_credentials",
            ).accessToken
        }
        return token
    }
}
