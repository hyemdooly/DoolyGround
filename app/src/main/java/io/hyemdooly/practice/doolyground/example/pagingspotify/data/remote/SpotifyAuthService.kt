package io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote

import io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.model.SpotifyTokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface SpotifyAuthService {
    @FormUrlEncoded
    @POST("api/token")
    suspend fun getAccessToken(
        @Header("Authorization") authorization: String,
        @Field("grant_type") grantType: String = "client_credentials",
    ): SpotifyTokenResponse
}
