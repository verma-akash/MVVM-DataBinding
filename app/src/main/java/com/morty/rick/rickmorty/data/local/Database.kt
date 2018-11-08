package com.morty.rick.rickmorty.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.morty.rick.rickmorty.data.models.Characters

/**
 * Created by Akash Verma on 08/11/18.
 */
@Database(entities = [(Characters::class)], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun characterDao(): CharactersDao
}