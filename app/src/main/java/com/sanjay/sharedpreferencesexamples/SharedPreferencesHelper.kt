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

    private inline fun SharedPreferences.edit(perform: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        editor.apply {
            perform.invoke(editor)
            apply()
        }
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
//    inline operator fun <reified T : Any> SharedPreferences.get(key: String, defaultValue: T? = null): T? {
//        // as? is a safe cast operator and so it returns null if type cast is failed.
//        // ?: is an elvis operator.
//        return when (T::class) {
//            String::class -> getString(key, defaultValue as? String) as T?
//            Int::class -> getInt(key, defaultValue as? Int ?: -1) as T?
//            Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
//            Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
//            Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
//            else -> throw UnsupportedOperationException("Not yet implemented")
//        }
//    }
}