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

    fun userRegistered(registered: Boolean) {
        myPref.edit().putBoolean("registered", registered).apply()
    }

    fun isUserRegistered(): Boolean {
        return myPref.getBoolean("registered", false)
    }

    fun userVerified(phone: String) {
        myPref.edit().putString("phone", phone).apply()
    }

    fun isUserVerified(): String {
        return myPref.getString("phone", "").toString()
    }
}