package com.fwhyn.android.data.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityScopedDataModule {
//    @Provides
//    fun provideModuleRepositoryImpl(sdkListLocalDataSource: SdkListLocalDataSource): SdkRepository {
//        return SdkRepositoryImpl(sdkListLocalDataSource)
//    }
}