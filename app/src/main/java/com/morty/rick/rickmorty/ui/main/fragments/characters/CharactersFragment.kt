package com.morty.rick.rickmorty.ui.main.fragments.characters

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.morty.rick.rickmorty.R
import com.morty.rick.rickmorty.models.Character
import com.morty.rick.rickmorty.models.Characters
import com.morty.rick.rickmorty.ui.base.BaseFragment

/**
 * Created by Akash Verma on 07/10/18.
 */
class CharactersFragment : BaseFragment(), CharactersRecyclerViewAdapter.ScrollInteractionListener {

    private lateinit var charactersViewModel: CharactersViewModel
    private lateinit var recyclerView: RecyclerView
    private var charactersList = arrayListOf<Character>()
    private var charactersRecyclerViewAdapter: CharactersRecyclerViewAdapter? = null
    private var pageNo = 0

    companion object {
        fun getInstance(): CharactersFragment {
            return CharactersFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        charactersViewModel = ViewModelProviders.of(this, fragViewModelFactory).get(CharactersViewModel::class.java)
        loadCharacters()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.characters_fragment, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersRecyclerViewAdapter = CharactersRecyclerViewAdapter(activity, charactersList, this)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = charactersRecyclerViewAdapter
        charactersViewModel.getAllCharacters().observe(this, charactersListObserver)
    }

    private var charactersListObserver = Observer<Characters> {
        if (it?.results?.size!! > 0) {
            val currentSize = charactersList.size
            charactersList.addAll(it.results)
            charactersRecyclerViewAdapter?.notifyItemInserted(currentSize)
        }
    }

    override fun loadCharacters() {
        pageNo++
        charactersViewModel.fetchAllCharacters(pageNo)
    }
}