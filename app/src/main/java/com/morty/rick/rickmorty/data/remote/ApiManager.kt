package com.morty.rick.rickmorty.data.remote

import android.arch.lifecycle.LiveData
import com.morty.rick.rickmorty.data.models.Characters

/**
 * Created by Akash Verma on 23/10/18.
 */
interface ApiManager {

    fun getAllCharactersFromApi(pageNo: String): LiveData<Characters>
}