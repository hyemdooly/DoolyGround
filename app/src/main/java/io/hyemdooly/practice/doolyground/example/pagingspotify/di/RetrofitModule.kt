package io.hyemdooly.practice.doolyground.example.pagingspotify.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.SpotifyAuthRetrofit
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    @Singleton
    @Provides
    fun provideAuthRetrofit(): Retrofit = SpotifyAuthRetrofit.createInstance()
}
