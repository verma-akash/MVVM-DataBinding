package com.morty.rick.rickmorty.utils

import android.content.Context
import android.net.ConnectivityManager
import com.morty.rick.rickmorty.injection.qualifiers.ApplicationContextQualifier
import javax.inject.Inject

/**
 * Created by Akash Verma on 31/10/18.
 */

class NetworkUtils @Inject constructor(@ApplicationContextQualifier private var context: Context) {

    fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }

}