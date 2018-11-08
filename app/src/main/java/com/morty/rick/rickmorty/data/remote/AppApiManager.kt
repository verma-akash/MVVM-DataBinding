package com.morty.rick.rickmorty.data.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.morty.rick.rickmorty.data.models.Characters
import com.morty.rick.rickmorty.network.ApiHelperService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Akash Verma on 23/10/18.
 */
class AppApiManager @Inject constructor(var apiHelperService: ApiHelperService) : ApiManager {

    override fun getAllCharactersFromApi(pageNo: String): LiveData<Characters> {

        val data = MutableLiveData<Characters>()

        apiHelperService.getAllCharacters(pageNo).enqueue(object : Callback<Characters> {

            override fun onResponse(call: Call<Characters>?, response: Response<Characters>?) {
                data.value = response?.body()
            }

            override fun onFailure(call: Call<Characters>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        return data
    }

}