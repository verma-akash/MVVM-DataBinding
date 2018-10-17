package com.morty.rick.rickmorty.ui.main.fragments.characters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.morty.rick.rickmorty.models.Characters
import com.morty.rick.rickmorty.network.ApiHelperService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Akash Verma on 08/10/18.
 */
class CharactersViewModel @Inject constructor(private var compositeDisposable: CompositeDisposable,
                                              private var apiHelperService: ApiHelperService) : ViewModel() {

    private var characters: MutableLiveData<Characters> = MutableLiveData()

    fun fetchAllCharacters(pageNo: Int) {
        Log.e("apiHelperService", apiHelperService.toString())
        Log.e("compositeDisposable", compositeDisposable.toString())

        compositeDisposable.add(apiHelperService
                .getAllCharacters(pageNo.toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    characters.postValue(it)
                }, {
                    Log.e("error", it.toString())
                }))
    }

    fun getAllCharacters(): LiveData<Characters> {
        return characters
    }
}