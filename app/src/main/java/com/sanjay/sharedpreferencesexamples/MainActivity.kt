package com.sanjay.sharedpreferencesexamples

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanjay.sharedpreferencesexamples.SharedPreferencesHelper.clearPrefs
import com.sanjay.sharedpreferencesexamples.SharedPreferencesHelper.customSharedPref
import com.sanjay.sharedpreferencesexamples.SharedPreferencesHelper.printAllKeyValuesOfSharedPref
import com.sanjay.sharedpreferencesexamples.SharedPreferencesHelper.removeKey
import com.sanjay.sharedpreferencesexamples.SharedPreferencesHelper.set

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sharePref = customSharedPref(context = this)
        sharePref?.apply {
            set("name", "Justin")
            set("age", 23)
            set("isAdult", true)
        }

        //sharePref?.removeKey("name")

       // Log.d(TAG, "SHAREDPREF: ${sharePref?.contains("name")}") // true
       // sharePref?.clearPrefs()
       // Log.d(TAG, "SHAREDPREF: ${sharePref?.contains("name")}") // false

        // to get Data
        val name = sharePref?.getString("name", null)
        val age = sharePref?.getInt("age", 0)
        val isAdult= sharePref?.getBoolean("isAdult", false)

        Log.d(TAG, "SHAREDPREF: name: $name age: $age isAdult: $isAdult")
//      Log.d(TAG, "SHAREDPREF: name: $firstKey")




    }
}