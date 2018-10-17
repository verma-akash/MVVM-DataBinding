package com.morty.rick.rickmorty.ui.main

import android.arch.lifecycle.ViewModel
import com.morty.rick.rickmorty.network.ApiHelperService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Akash Verma on 05/09/18.
 */

class MainActivityViewModel @Inject constructor(private var compositeDisposable: CompositeDisposable,
                                                private var apiHelperService: ApiHelperService) : ViewModel() {

}