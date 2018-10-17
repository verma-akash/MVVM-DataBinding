package com.morty.rick.rickmorty.injection.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.morty.rick.rickmorty.ProjectViewModelFactory
import com.morty.rick.rickmorty.injection.scopes.ActivityScope
import com.morty.rick.rickmorty.ui.main.MainActivityViewModel
import com.morty.rick.rickmorty.ui.splash.SplashActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Created by Akash Verma on 27/09/18.
 */
@Module
abstract class ViewModelModule {

    @Binds
    @ActivityScope
    internal abstract fun bindViewModelFactory(factory: ProjectViewModelFactory): ViewModelProvider.Factory

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(SplashActivityViewModel::class)
    internal abstract fun bindSplashViewModel(splashActivityViewModel: SplashActivityViewModel): ViewModel

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}