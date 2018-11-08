package com.morty.rick.rickmorty.injection.modules

import android.arch.persistence.room.Room
import com.morty.rick.rickmorty.RickAndMortyApplication
import com.morty.rick.rickmorty.data.AppDataManager
import com.morty.rick.rickmorty.data.DataManager
import com.morty.rick.rickmorty.data.local.AppDataBaseManager
import com.morty.rick.rickmorty.data.local.CharactersDao
import com.morty.rick.rickmorty.data.local.DataBaseManager
import com.morty.rick.rickmorty.data.local.Database
import com.morty.rick.rickmorty.data.remote.ApiManager
import com.morty.rick.rickmorty.data.remote.AppApiManager
import com.morty.rick.rickmorty.injection.scopes.ApplicationScope
import com.morty.rick.rickmorty.utils.NetworkUtils
import dagger.Module
import dagger.Provides

/**
 * Created by Akash Verma on 07/09/18.
 */
@Module(includes = [(GlideModule::class), (ApiHelperServiceModule::class)])
class ApplicationModule {

    @Provides
    @ApplicationScope
    fun providesNetworkUtils(rickAndMortyApplication: RickAndMortyApplication): NetworkUtils {
        return NetworkUtils(rickAndMortyApplication.applicationContext)
    }

    @Provides
    @ApplicationScope
    fun providesDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @ApplicationScope
    fun providesApiManager(appApiManager: AppApiManager): ApiManager {
        return appApiManager
    }

    @Provides
    @ApplicationScope
    fun providesDataBaseManager(appDataBaseManager: AppDataBaseManager): DataBaseManager {
        return appDataBaseManager
    }

    @Provides
    @ApplicationScope
    fun provideCharactersDatabase(rickAndMortyApplication: RickAndMortyApplication):
            Database = Room.databaseBuilder(rickAndMortyApplication,
            Database::class.java, "rickAndMorty_db").build()

    @Provides
    @ApplicationScope
    fun provideCharactersDao(database: Database): CharactersDao = database.characterDao()

}