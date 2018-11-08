package com.morty.rick.rickmorty.network

import com.morty.rick.rickmorty.data.models.Characters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Akash Verma on 08/10/18.
 */
interface ApiHelperService {

    @GET("character/")
    fun getAllCharacters(@Query("page") pageNo: String): Call<Characters>

}