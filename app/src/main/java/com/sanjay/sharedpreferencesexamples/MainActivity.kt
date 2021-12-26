package com.sanjay.sharedpreferencesexamples

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.customSharedPref
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.getObject
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.set
import com.sanjay.sharedpreferencesexamples.utils.SharedPreferencesHelper.setObject
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    // inject object of ShredPreference
    /** var  sharedPref: SharedPreferences?=null
          @Inject set
    */
    @set:Inject
    internal var sharedPref:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userData = UserData("JB", 23, listOf(2,3,4))

        // without using inject
//        val sharedPref = customSharedPref(context = this)

        sharedPref?.apply {
            set("name", "Justin")
            set("age", 23)
            set("isAdult", true)
        }

        //sharePref?.removeKey("name")

       // Log.d(TAG, "SHAREDPREF: ${sharePref?.contains("name")}") // true
       // sharePref?.clearPrefs()
       // Log.d(TAG, "SHAREDPREF: ${sharePref?.contains("name")}") // false

        // to get Data
        val name = sharedPref?.getString("name", null)
        val age = sharedPref?.getInt("age", 0)
        val isAdult= sharedPref?.getBoolean("isAdult", false)

        Log.d(TAG, "SHAREDPREF: name: $name age: $age isAdult: $isAdult")
//      Log.d(TAG, "SHAREDPREF: name: $firstKey")


        sharedPref?.setObject("UserData",userData )
        val user: UserData? = sharedPref?.getObject("UserData",UserData::class.java)
        Log.d(TAG, "onCreate: UserData$user", )
    }

}