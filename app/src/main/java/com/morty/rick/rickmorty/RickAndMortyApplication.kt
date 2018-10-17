package com.morty.rick.rickmorty

import android.app.Activity
import android.app.Application
import com.morty.rick.rickmorty.injection.component.ApplicationComponent
import com.morty.rick.rickmorty.injection.component.DaggerApplicationComponent

/**
 * Created by Akash Verma on 05/09/18.
 */
class RickAndMortyApplication : Application() {

//    @Inject
//    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var applicationComponent: ApplicationComponent

    companion object {
        fun get(activity: Activity): RickAndMortyApplication {
            return activity.application as RickAndMortyApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .application(this)
                .build()

        applicationComponent.inject(this)

    }

//    override fun activityInjector(): AndroidInjector<Activity> {
//        return dispatchingAndroidInjector
//    }
}