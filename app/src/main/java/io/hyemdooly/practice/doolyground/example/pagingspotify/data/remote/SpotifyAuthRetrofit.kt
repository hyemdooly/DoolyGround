package io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import io.hyemdooly.practice.doolyground.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class SpotifyAuthRetrofit {
    companion object {
        fun createInstance(): Retrofit =
            Retrofit
                .Builder()
                .client(createClient())
                .baseUrl(BuildConfig.BASE_AUTH_URL)
                .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                .build()

        private fun createClient(): OkHttpClient =
            OkHttpClient
                .Builder()
                .apply {
                    addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                }.build()
    }
}
