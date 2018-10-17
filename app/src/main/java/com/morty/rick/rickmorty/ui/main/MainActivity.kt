package com.morty.rick.rickmorty.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.morty.rick.rickmorty.R
import com.morty.rick.rickmorty.ui.base.BaseActivity
import com.morty.rick.rickmorty.ui.main.fragments.characters.CharactersFragment
import com.morty.rick.rickmorty.ui.main.fragments.episodes.EpisodesFragment
import com.morty.rick.rickmorty.ui.main.fragments.locations.LocationsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent.inject(this)

        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.characters -> openCharactersFragment()
                R.id.locations -> openLocationsFragment()
                R.id.episodes -> openEpisodesFragment()
                else -> openCharactersFragment()
            }
        }

        openCharactersFragment()
    }

    private fun openEpisodesFragment(): Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var episodesFragment = supportFragmentManager.findFragmentByTag(EPISODES_FRAGMENT)
        if (episodesFragment == null)
            episodesFragment = EpisodesFragment.getInstance()
        fragmentTransaction.replace(R.id.main_container, episodesFragment, EPISODES_FRAGMENT)
                .addToBackStack(null)
        fragmentTransaction.commit()
        return true
    }

    private fun openLocationsFragment(): Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var locationsFragment = supportFragmentManager.findFragmentByTag(LOCATIONS_FRAGMENT)
        if (locationsFragment == null)
            locationsFragment = LocationsFragment.getInstance()
        fragmentTransaction.replace(R.id.main_container, locationsFragment, LOCATIONS_FRAGMENT)
                .addToBackStack(null)
        fragmentTransaction.commit()
        return true
    }

    private fun openCharactersFragment(): Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var charactersFragment = supportFragmentManager.findFragmentByTag(CHARACTERS_FRAGMENT)
        if (charactersFragment == null)
            charactersFragment = CharactersFragment.getInstance()
        fragmentTransaction.replace(R.id.main_container, charactersFragment, CHARACTERS_FRAGMENT)
                .addToBackStack(null)
        fragmentTransaction.commit()
        return true
    }

    companion object {
        const val CHARACTERS_FRAGMENT = "characters_fragment"
        const val LOCATIONS_FRAGMENT = "locations_fragment"
        const val EPISODES_FRAGMENT = "episodes_fragment"
    }

    override fun onBackPressed() {
        if(bottom_navigation.selectedItemId != R.id.characters)
            bottom_navigation.selectedItemId = R.id.characters
        else
            finish()
    }
}
