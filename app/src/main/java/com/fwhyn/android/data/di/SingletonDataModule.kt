package com.fwhyn.android.data.di

import com.fwhyn.android.data.local.SdkListLocalDataSource
import com.fwhyn.android.data.repository.SdkRepository
import com.fwhyn.android.data.repository.SdkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SingletonDataModule {

    @Provides
    @Singleton
    fun provideModuleLocalDataSource(): SdkListLocalDataSource {
        return SdkListLocalDataSource()
    }

    @Provides
    fun provideModuleRepositoryImpl(sdkListLocalDataSource: SdkListLocalDataSource): SdkRepository {
        return SdkRepositoryImpl(sdkListLocalDataSource)
    }
}