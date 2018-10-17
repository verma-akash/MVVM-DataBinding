package com.morty.rick.rickmorty

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.morty.rick.rickmorty.injection.scopes.ActivityScope
import javax.inject.Inject
import javax.inject.Provider


/**
 * Created by Akash Verma on 07/09/18.
 */
@ActivityScope
class ProjectViewModelFactory @Inject constructor(private var creators: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
        ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator = creators[modelClass]
        if (creator == null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class $modelClass")
        }
        try {
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}