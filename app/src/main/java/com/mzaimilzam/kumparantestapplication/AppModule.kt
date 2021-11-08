package com.mzaimilzam.kumparantestapplication

import com.mzaimilzam.core.domain.usecase.AllPostInteractor
import com.mzaimilzam.core.domain.usecase.IAllPostUsecase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideAllPostusecase(allPostInteractor : AllPostInteractor): IAllPostUsecase

}