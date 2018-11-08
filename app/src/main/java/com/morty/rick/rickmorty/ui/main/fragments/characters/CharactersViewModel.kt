package com.morty.rick.rickmorty.ui.main.fragments.characters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.morty.rick.rickmorty.data.DataManager
import com.morty.rick.rickmorty.data.models.Characters
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akash Verma on 08/10/18.
 */
class CharactersViewModel @Inject constructor(private var dataManager: DataManager, private var compositeDisposable: CompositeDisposable) : ViewModel() {

    private lateinit var characters: LiveData<Characters>
    private var charactersMediatorLiveData = MediatorLiveData<Characters>()

    fun fetchAllCharacters(pageNo: String) {

        characters = dataManager.getAllCharacters(pageNo)

        charactersMediatorLiveData.addSource(characters, {
            charactersMediatorLiveData.postValue(it)

            if(pageNo == "1")
                dataManager.saveCharacters(it)
        })

//        compositeDisposable
//                .add(dataManager
//                        .getAllCharacters(pageNo)
//                        ?.subscribeOn(Schedulers.io())
//                        ?.observeOn(AndroidSchedulers.mainThread())
//                        ?.subscribe({
//                            characters.postValue(it)
//                        }, {
//
//                        })!!)
    }

    fun getAllCharacters(): LiveData<Characters> {
        return charactersMediatorLiveData
    }
}