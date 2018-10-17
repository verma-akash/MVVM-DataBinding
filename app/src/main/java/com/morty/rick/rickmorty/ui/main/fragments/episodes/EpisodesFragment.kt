package com.morty.rick.rickmorty.ui.main.fragments.episodes

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.morty.rick.rickmorty.R

/**
 * Created by Akash Verma on 07/10/18.
 */
class EpisodesFragment : Fragment() {

    companion object {
        fun getInstance(): EpisodesFragment {
            return EpisodesFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.characters_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}