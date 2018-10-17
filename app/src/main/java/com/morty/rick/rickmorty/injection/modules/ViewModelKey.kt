package com.morty.rick.rickmorty.injection.modules

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import kotlin.reflect.KClass


/**
 * Created by Akash Verma on 27/09/18.
 */

@Target(ElementType.METHOD)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)