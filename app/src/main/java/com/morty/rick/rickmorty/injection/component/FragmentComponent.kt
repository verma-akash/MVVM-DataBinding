package com.morty.rick.rickmorty.injection.component

import com.morty.rick.rickmorty.injection.modules.FragmentModule
import com.morty.rick.rickmorty.injection.modules.FragmentViewModelModule
import com.morty.rick.rickmorty.injection.scopes.FragmentScope
import com.morty.rick.rickmorty.ui.base.BaseFragment
import dagger.BindsInstance
import dagger.Subcomponent

/**
 * Created by Akash Verma on 08/10/18.
 */
@FragmentScope
@Subcomponent(modules = [(FragmentModule::class), (FragmentViewModelModule::class)])
interface FragmentComponent {

    @Subcomponent.Builder
    interface Builder {

        @BindsInstance
        fun fragment(baseFragment: BaseFragment): Builder

        fun build(): FragmentComponent
    }

    fun inject(baseFragment: BaseFragment)
}