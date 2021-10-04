package com.sanjay.sharedpreferencesexamples

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


/**
* Created By Sanjay Prajapat
* Date - 4-sept-2021 11:23 PM
* */
object SharedPreferencesHelper {

    fun customSharedPref(context:Context?) = context?.getSharedPreferences("mySharedPref", Context.MODE_PRIVATE)

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }
    operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is String? -> edit { it.putString(key, value) }
            is Int -> edit { it.putInt(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is Long -> edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }
}