package com.fwhyn.android.domain.di

import com.fwhyn.android.data.repository.SdkRepository
import com.fwhyn.android.domain.usecase.SelectSdkUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityScopedDomainModule {
    @Provides
    fun provideSelectSdkUseCase(sdkRepository: SdkRepository): SelectSdkUseCase {
        return SelectSdkUseCase(sdkRepository)
    }
}