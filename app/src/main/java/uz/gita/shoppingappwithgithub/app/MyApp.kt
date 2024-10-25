package uz.gita.shoppingappwithgithub.app

import android.app.Application
import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.MyPref

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        MyPref.init(getSharedPreferences("ShoppingApp", MODE_PRIVATE))
        AppDatabase.init(this)
    }
}