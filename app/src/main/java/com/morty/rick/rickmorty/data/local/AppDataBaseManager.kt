package com.morty.rick.rickmorty.data.local

import android.arch.lifecycle.LiveData
import com.morty.rick.rickmorty.data.models.Characters
import javax.inject.Inject

/**
 * Created by Akash Verma on 23/10/18.
 */
class AppDataBaseManager @Inject constructor(private var charactersDao: CharactersDao) : DataBaseManager {

    override fun getAllCharactersFromDb(): LiveData<Characters> {
        return charactersDao.queryCharacters()
    }


    override fun saveCharacters(characters: Characters?) {
        if (characters != null) {
            Thread(Runnable {
                charactersDao.insertCharacters(characters)
            }).start()
        }
    }
}