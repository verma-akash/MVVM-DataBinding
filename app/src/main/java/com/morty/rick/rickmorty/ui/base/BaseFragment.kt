package com.morty.rick.rickmorty.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import com.morty.rick.rickmorty.FragmentViewModelFactory
import com.morty.rick.rickmorty.RickAndMortyApplication
import com.morty.rick.rickmorty.injection.component.FragmentComponent
import javax.inject.Inject

/**
 * Created by Akash Verma on 08/10/18.
 */
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var fragViewModelFactory: FragmentViewModelFactory

    lateinit var fragmentComponent: FragmentComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentComponent = RickAndMortyApplication.get(activity!!).applicationComponent
                .fragmentBuilder()
                .fragment(this)
                .build()

        fragmentComponent.inject(this)
    }
}