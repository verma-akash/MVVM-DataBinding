package com.morty.rick.rickmorty.injection.scopes

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by Akash Verma on 08/10/18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class FragmentScope