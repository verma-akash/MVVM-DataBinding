package com.morty.rick.rickmorty.network

import com.morty.rick.rickmorty.models.Characters
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Akash Verma on 08/10/18.
 */
interface ApiHelperService {

    @GET("character/")
    fun getAllCharacters(@Query("page") pageNo: String): Observable<Characters>

}