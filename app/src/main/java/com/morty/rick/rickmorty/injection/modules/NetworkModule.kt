package com.morty.rick.rickmorty.injection.modules;


import android.util.Log
import com.morty.rick.rickmorty.injection.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Akash Verma on 24/07/18.
 */

@Module
class NetworkModule {
    @Provides
    @ApplicationScope
    fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
    }

    @Provides
    @ApplicationScope
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.e("Network Call", it)
        }).setLevel(HttpLoggingInterceptor.Level.BASIC)
    }
}