package com.sanjay.sharedpreferencesexamples

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.customSharedPref
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.getObject
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.set
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.setObject

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userData = UserData("JB", 23, listOf(2,3,4))




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


        sharePref?.setObject("UserData",userData )
        val user: UserData? = sharePref?.getObject("UserData",UserData::class.java)
//        Log.d(TAG, "onCreate: UserData", user)

    }
}