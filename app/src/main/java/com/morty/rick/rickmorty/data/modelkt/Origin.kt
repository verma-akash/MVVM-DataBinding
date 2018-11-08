package com.morty.rick.rickmorty.data.modelkt

import android.arch.persistence.room.Entity
import com.google.gson.annotations.Expose
import java.io.Serializable

/**
 * Created by Akash Verma on 08/11/18.
 */

@Entity(tableName = "origin")
data class Origin(

        @Expose
        private var name: String? = null,

        @Expose
        private var url: String? = null

) : Serializable