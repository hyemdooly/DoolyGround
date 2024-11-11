package io.hyemdooly.practice.doolyground.example.pagingspotify.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.remote.SpotifyAuthService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {
    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): SpotifyAuthService =
        retrofit.create(SpotifyAuthService::class.java)
}
