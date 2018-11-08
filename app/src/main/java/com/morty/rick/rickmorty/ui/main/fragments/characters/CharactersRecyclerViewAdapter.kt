package com.morty.rick.rickmorty.ui.main.fragments.characters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.morty.rick.rickmorty.R
import com.morty.rick.rickmorty.data.models.Character
import com.morty.rick.rickmorty.databinding.SingleCharacterHolderBinding

/**
 * Created by Akash Verma on 08/10/18.
 */
class CharactersRecyclerViewAdapter constructor() : RecyclerView.Adapter<CharactersRecyclerViewAdapter.CharacterHolder>() {

    private var context: Context? = null
    private var listOfCharacters: List<Character>? = null
    private var scrollInteractionListener: ScrollInteractionListener? = null

    constructor(context: Context?, listOfCharacters: List<Character>?,
                scrollInteractionListener: ScrollInteractionListener) : this() {
        this.context = context
        this.listOfCharacters = listOfCharacters
        this.scrollInteractionListener = scrollInteractionListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): CharacterHolder {
        var singleCharacterHolderBinding =
                DataBindingUtil.inflate<SingleCharacterHolderBinding>(LayoutInflater.from(context),
                        R.layout.single_character_holder, viewGroup, false)

        singleCharacterHolderBinding.clickHandler = ClickHandler(context)

//        Log.e("onCreateViewHolder", onCreate.toString())
        return CharacterHolder(singleCharacterHolderBinding)
    }

    override fun getItemCount(): Int {
        return listOfCharacters?.size ?: 0
    }

    override fun onBindViewHolder(characterHolder: CharacterHolder, position: Int) {
//        Log.e("onBindViewHolder", onBind.toString())
        characterHolder.characterBinding.character = listOfCharacters!![position]

        if (position + 2 == listOfCharacters?.size ?: 2)
            scrollInteractionListener?.loadCharacters()
    }

    class CharacterHolder(singleCharacterHolderBinding: SingleCharacterHolderBinding) :
            RecyclerView.ViewHolder(singleCharacterHolderBinding.root) {
        var characterBinding = singleCharacterHolderBinding
    }

    interface ScrollInteractionListener {
        fun loadCharacters()
    }

    class ClickHandler constructor(private var context: Context?) {

        fun onCharacterImageClick(view: View, characterName: String?) {
            Toast.makeText(context, characterName, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        var onCreate = 0
        var onBind = 0
    }
}