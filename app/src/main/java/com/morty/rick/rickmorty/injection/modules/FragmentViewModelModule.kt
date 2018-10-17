package com.morty.rick.rickmorty.injection.modules

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.morty.rick.rickmorty.FragmentViewModelFactory
import com.morty.rick.rickmorty.injection.scopes.FragmentScope
import com.morty.rick.rickmorty.ui.main.fragments.characters.CharactersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Akash Verma on 08/10/18.
 */
@Module
abstract class FragmentViewModelModule {

    @FragmentScope
    @Binds
    internal abstract fun bindViewModelFactory(factory: FragmentViewModelFactory): ViewModelProvider.Factory

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    internal abstract fun bindCharactersViewModel(charactersViewModel: CharactersViewModel): ViewModel
}