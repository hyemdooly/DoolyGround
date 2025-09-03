package io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote

import io.hyemdooly.practice.doolyground.BuildConfig
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.datasource.AuthDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Inject

class SpotifyRetrofit @Inject constructor() {
    companion object {
        private const val HTTP_LOG_TAG = "HTTP_LOG"
        private const val AUTHORIZATION = "Authorization"

        fun createInstance(authDataSource: AuthDataSource): Retrofit =
            Retrofit
                .Builder()
                .baseUrl(BuildConfig.BASE_API_URL)
                .client(getClient(authDataSource))
                .build()

        private fun getClient(authDataSource: AuthDataSource): OkHttpClient {
            return OkHttpClient
                .Builder()
                .addInterceptor(getAuthInterceptor(authDataSource))
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        }

        private fun getAuthInterceptor(authDataSource: AuthDataSource): Interceptor {
            var token = ""
            runBlocking {
                token = authDataSource.getToken()
            }

            return Interceptor { chain: Interceptor.Chain ->
                val requestAddedToken = chain.request()
                    .newBuilder()
                    .addHeader(AUTHORIZATION, "Bearer $token")
                    .build()

                chain.proceed(requestAddedToken)
            }
        }
    }
}
