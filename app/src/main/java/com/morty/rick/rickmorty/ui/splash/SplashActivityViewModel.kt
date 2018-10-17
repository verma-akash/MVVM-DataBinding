package com.morty.rick.rickmorty.ui.splash

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.morty.rick.rickmorty.network.ApiHelperService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akash Verma on 05/09/18.
 */
class SplashActivityViewModel @Inject constructor(var compositeDisposable: CompositeDisposable,
                                                  var apiHelperService: ApiHelperService) : ViewModel() {

    fun getAllCharacter() {
        Log.e("apiHelperService", apiHelperService.toString())
        Log.e("compositeDisposable", compositeDisposable.toString())
    }
}