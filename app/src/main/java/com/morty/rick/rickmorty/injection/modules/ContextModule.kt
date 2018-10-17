package com.morty.rick.rickmorty.injection.modules;

import android.content.Context;
import com.morty.rick.rickmorty.RickAndMortyApplication
import com.morty.rick.rickmorty.injection.qualifiers.ApplicationContextQualifier
import com.morty.rick.rickmorty.injection.scopes.ApplicationScope


import dagger.Module;
import dagger.Provides;

/**
 * Created by Akash Verma on 24/07/18.
 */

@Module
class ContextModule(private val rickAndMortyApplication: RickAndMortyApplication) {

    @Provides
    @ApplicationScope
    @ApplicationContextQualifier
    fun providesApplicationContext(): Context {
        return rickAndMortyApplication.applicationContext
    }
}