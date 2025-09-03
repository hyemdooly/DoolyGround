package io.hyemdooly.practice.doolyground.example.pagingspotify.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
//    @Singleton
//    @Binds
//    abstract fun bindAuthRepository(authRepository: AuthRepositoryImpl): AuthRepository
}
