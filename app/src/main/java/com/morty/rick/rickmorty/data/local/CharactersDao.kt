package com.morty.rick.rickmorty.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.morty.rick.rickmorty.data.models.Characters

/**
 * Created by Akash Verma on 08/11/18.
 */
@Dao
interface CharactersDao {

    @Query("SELECT * FROM characters")
    fun queryCharacters(): LiveData<Characters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(characters: Characters)
}