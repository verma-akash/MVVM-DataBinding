package com.morty.rick.rickmorty.injection.modules;

import com.morty.rick.rickmorty.injection.qualifiers.ActivityContextQualifier
import com.morty.rick.rickmorty.injection.scopes.ActivityScope
import com.morty.rick.rickmorty.ui.base.BaseActivity
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akash Verma on 24/07/18.
 */

@Module
class ActivityModule {

    @Provides
    @ActivityScope
    @ActivityContextQualifier
    fun providesActivityContext(baseActivity: BaseActivity): BaseActivity {
        return baseActivity
    }

    @Provides
    @ActivityScope
    fun getCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}