package com.morty.rick.rickmorty.injection.component;

import com.morty.rick.rickmorty.RickAndMortyApplication
import com.morty.rick.rickmorty.injection.modules.ApplicationModule
import com.morty.rick.rickmorty.injection.scopes.ApplicationScope
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Akash Verma on 24/07/18.
 */

@ApplicationScope
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun activityBuilder(): ActivityComponent.Builder

    fun fragmentBuilder(): FragmentComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(rickAndMortyApplication: RickAndMortyApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(rickAndMortyApplication: RickAndMortyApplication)

//    fun inject(charactersRecyclerViewAdapter: CharactersRecyclerViewAdapter)

}
