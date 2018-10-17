package com.morty.rick.rickmorty.injection.component

import com.morty.rick.rickmorty.injection.modules.ActivityModule
import com.morty.rick.rickmorty.injection.modules.ViewModelModule
import com.morty.rick.rickmorty.injection.scopes.ActivityScope
import com.morty.rick.rickmorty.ui.base.BaseActivity
import com.morty.rick.rickmorty.ui.main.MainActivity
import com.morty.rick.rickmorty.ui.splash.SplashActivity
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by Akash Verma on 02/10/18.
 */
@ActivityScope
@Subcomponent(modules = [(ActivityModule::class), (ViewModelModule::class)])
interface ActivityComponent {

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun activity(baseActivity: BaseActivity): Builder

        fun build(): ActivityComponent
    }

    fun inject(baseActivity: BaseActivity)

    fun inject(mainActivity: MainActivity)

    fun inject(splashActivity: SplashActivity)
}