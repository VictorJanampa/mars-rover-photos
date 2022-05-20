package com.example.data.di

import com.example.data.repository.PhotoRepository
import com.example.data.repository.PhotoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@InstallIn(ViewModelComponent::class)
@Module
object MyModule {
    @Provides
    fun provideRepository(): PhotoRepository {
        return PhotoRepositoryImpl()
    }
}
