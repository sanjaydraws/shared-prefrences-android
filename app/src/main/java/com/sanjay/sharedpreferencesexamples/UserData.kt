package com.sanjay.sharedpreferencesexamples

data class UserData(
    val name:String? = null,
    val age:Int? = null,
    val numbers: List<Int> = ArrayList()
        )