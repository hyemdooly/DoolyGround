package io.hyemdooly.practice.doolyground.example.pagingspotify.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.repository.AuthRepository
import io.hyemdooly.practice.doolyground.example.pagingspotify.data.repository.AuthRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindAuthRepository(authRepository: AuthRepositoryImpl): AuthRepository
}
