package com.morty.rick.rickmorty.data

import android.arch.lifecycle.LiveData
import com.morty.rick.rickmorty.data.local.DataBaseManager
import com.morty.rick.rickmorty.data.local.SharedPreferenceManager
import com.morty.rick.rickmorty.data.models.Characters
import com.morty.rick.rickmorty.data.remote.ApiManager

/**
 * Created by Akash Verma on 22/10/18.
 */
interface DataManager : SharedPreferenceManager, ApiManager, DataBaseManager {

    fun getAllCharacters(pageNo: String): LiveData<Characters>
}