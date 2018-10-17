package com.morty.rick.rickmorty.injection.modules

import dagger.Module

/**
 * Created by Akash Verma on 07/09/18.
 */
@Module(includes = [(GlideModule::class), (ApiHelperServiceModule::class)])
class ApplicationModule