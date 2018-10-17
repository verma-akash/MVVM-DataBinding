package com.morty.rick.rickmorty.injection.modules

import com.morty.rick.rickmorty.injection.scopes.FragmentScope
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akash Verma on 08/10/18.
 */

@Module
class FragmentModule {

    @Provides
    @FragmentScope
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}