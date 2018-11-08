package com.morty.rick.rickmorty.data

import android.arch.lifecycle.*
import com.morty.rick.rickmorty.data.local.DataBaseManager
import com.morty.rick.rickmorty.data.models.Characters
import com.morty.rick.rickmorty.data.remote.ApiManager
import com.morty.rick.rickmorty.utils.NetworkUtils
import javax.inject.Inject

/**
 * Created by Akash Verma on 22/10/18.
 */
class AppDataManager @Inject constructor(private var apiManager: ApiManager,
                                         private var dataBaseManager: DataBaseManager) : DataManager {

    @Inject
    lateinit var networkUtils: NetworkUtils

    override fun getAllCharacters(pageNo: String): LiveData<Characters> {
        return if (networkUtils.isNetworkConnected()) {
            getAllCharactersFromApi(pageNo)
        } else {
            if (pageNo == "1")
                getAllCharactersFromDb()
            else
                MutableLiveData()
        }
    }


    override fun getAllCharactersFromApi(pageNo: String): LiveData<Characters> {
        return apiManager.getAllCharactersFromApi(pageNo)
    }

    override fun getAllCharactersFromDb(): LiveData<Characters> {
        return dataBaseManager.getAllCharactersFromDb()
    }

    override fun saveCharacters(characters: Characters?) {
        return dataBaseManager.saveCharacters(characters)
    }
}