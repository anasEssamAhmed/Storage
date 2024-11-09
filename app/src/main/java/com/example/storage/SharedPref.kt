package com.example.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity

object SharedPref {
    private const val sharedPrefName = "SHARED_PREFERENCE"
    private const val KeyName = "USERNAME"
    private var sharedPreferences: SharedPreferences? = null

    fun initSharedPreference(context: Context) {
        sharedPreferences = context.getSharedPreferences(
            sharedPrefName,
            AppCompatActivity.MODE_PRIVATE
        )
    }

    var username:String?
        get() = sharedPreferences?.getString(KeyName , null)
        set(value) = sharedPreferences!!.edit().putString(KeyName , value).apply()


}