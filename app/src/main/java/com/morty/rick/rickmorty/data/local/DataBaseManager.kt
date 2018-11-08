package com.morty.rick.rickmorty.data.local

import android.arch.lifecycle.LiveData
import com.morty.rick.rickmorty.data.models.Characters

/**
 * Created by Akash Verma on 23/10/18.
 */
interface DataBaseManager {

    fun getAllCharactersFromDb(): LiveData<Characters>

    fun saveCharacters(characters: Characters?)
}