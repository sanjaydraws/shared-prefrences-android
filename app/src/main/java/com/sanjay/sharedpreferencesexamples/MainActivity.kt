package com.sanjay.sharedpreferencesexamples

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sanjay.sharedpreferencesexamples.SharedPreferencesHelper.customSharedPref
import com.sanjay.sharedpreferencesexamples.SharedPreferencesHelper.printAllKeyValuesOfSharedPref

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val sharePref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        val sharePref = customSharedPref(context = this)
        val editor: SharedPreferences.Editor? = sharePref?.edit()

//        // to save data
        editor?.apply {
            putString("name", "Justin")
            putInt("age", 23)
            putBoolean("isAdult", true)
            apply()
        }


//        SharedPreferencesHelper.customSharedPref(context = this)?.set("firstKey","" )
//        val firstKey = SharedPreferencesHelper.customSharedPref(context = this)?.get("firstKey", null)


        editor?.clear()
        editor?.apply()


        // to get Data
        val name = sharePref?.getString("name", null)
        val age = sharePref?.getInt("age", 0)
        val isAdult= sharePref?.getBoolean("isAdult", false)

        Log.d(TAG, "SHAREDPREF: name: $name age: $age isAdult: $isAdult")
//        Log.d(TAG, "SHAREDPREF: name: $firstKey")

        //retrieve all values from particular shared preference file
       /* val allEntries: Map<String, *> = sharePref.all
        for ((key, value) in allEntries) {
            Log.d("mapValues", "$key: $value")
        } */



    }
}