package com.morty.rick.rickmorty.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.morty.rick.rickmorty.ProjectViewModelFactory
import com.morty.rick.rickmorty.RickAndMortyApplication
import com.morty.rick.rickmorty.injection.component.ActivityComponent
import javax.inject.Inject


/**
 * Created by Akash Verma on 05/09/18.
 */
abstract class BaseActivity: AppCompatActivity() {

    @Inject
    lateinit var projectViewModelFactory: ProjectViewModelFactory

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityComponent = RickAndMortyApplication.get(this).applicationComponent.activityBuilder()
                .activity(this)
                .build()

        activityComponent.inject(this)
    }
}