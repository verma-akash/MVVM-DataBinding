package com.morty.rick.rickmorty.injection.modules;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.morty.rick.rickmorty.injection.qualifiers.ApplicationContextQualifier
import com.morty.rick.rickmorty.injection.scopes.ApplicationScope

import dagger.Module;
import dagger.Provides;

/**
 * Created by Akash Verma on 24/07/18.
 */

@Module
class GlideModule {

    @Provides
    @ApplicationScope
    fun providesGlideRequestManager(@ApplicationContextQualifier context: Context): RequestManager {
        return Glide.with(context)
    }
}