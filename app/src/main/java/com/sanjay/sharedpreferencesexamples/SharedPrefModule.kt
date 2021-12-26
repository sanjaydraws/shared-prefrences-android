package com.sanjay.sharedpreferencesexamples

import android.content.Context
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefModule {

      val PREFS_PRIVATE_MODE = Context.MODE_PRIVATE

    @Provides
    @Singleton
    fun customSharedPref(@ApplicationContext context: Context?) = context?.getSharedPreferences("mySharedPref",
        Context.MODE_PRIVATE
    )


}