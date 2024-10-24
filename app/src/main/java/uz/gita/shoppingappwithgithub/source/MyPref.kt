package uz.gita.shoppingappwithgithub.source

import android.content.SharedPreferences

object MyPref {
    private lateinit var myPref: SharedPreferences

    fun init(preferences: SharedPreferences) {
        this.myPref = preferences
    }

    fun userFirstVisit(visited: Boolean) {
        myPref.edit().putBoolean("visited", visited).apply()
    }

    fun isUserFirstVisit(): Boolean {
        return myPref.getBoolean("visited", false)
    }
}