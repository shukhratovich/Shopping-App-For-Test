package uz.gita.shoppingappwithgithub.app

import android.app.Application
import uz.gita.shoppingappwithgithub.R
import uz.gita.shoppingappwithgithub.source.AppDatabase
import uz.gita.shoppingappwithgithub.source.MyPref
import uz.gita.shoppingappwithgithub.source.entity.CategoryEntity
import uz.gita.shoppingappwithgithub.source.entity.ProductEntity

class MyApp : Application() {
    private lateinit var database: AppDatabase
    override fun onCreate() {
        super.onCreate()
        MyPref.init(getSharedPreferences("ShoppingApp", MODE_PRIVATE))
        AppDatabase.init(this)

        database = AppDatabase.instance
        if (database.getCategoryDao().getAll().isEmpty()) {
            database.getCategoryDao()
                .add(CategoryEntity(0, "Elektronika", R.drawable.category_technology))
            database.getCategoryDao()
                .add(CategoryEntity(0, "Maishiy texnika", R.drawable.category_electronika))
            database.getCategoryDao().add(CategoryEntity(0, "Kiyim", R.drawable.category_wear))
            database.getCategoryDao()
                .add(CategoryEntity(0, "Poyabzallar", R.drawable.category_shoes))
            database.getCategoryDao()
                .add(CategoryEntity(0, "Aksessuarlar", R.drawable.category_accessuar))
            database.getCategoryDao()
                .add(CategoryEntity(0, "Salomatlik", R.drawable.category_healthy))
            database.getCategoryDao()
                .add(CategoryEntity(0, "Avtotovarlar", R.drawable.category_auto))

            database.getProductDao().add(
                ProductEntity(
                    0,
                    R.drawable.product_elektronika,
                    "Smartfon Xiaomi Redmi Note 13, 6/128 GB, 8/128 GB, 8/256GB,…",
                    "4 997 000",
                    "2 479 000",
                    false,
                    false,
                    1
                )
            )
            database.getProductDao().add(
                ProductEntity(
                    0,
                    R.drawable.product_texnika,
                    "Havo tozalagich Avura iqlim kompleksi, isitish, namlash,",
                    "2 400 000",
                    "1 480 000",
                    false,
                    false,
                    2
                )
            )
            database.getProductDao().add(
                ProductEntity(
                    0,
                    R.drawable.product_shoes,
                    "Erkaklar krossovkalari FLO KINETIX",
                    "499 000",
                    "424 000",
                    false,
                    false,
                    3
                )
            )
            database.getProductDao().add(
                ProductEntity(
                    0,
                    R.drawable.product_accessuar,
                    "Havo xushbo'ylantirgich avtomobil uchun",
                    "499 000",
                    "424 000",
                    isFavourite = false,
                    isInBasket = false,
                    categoryId = 4
                )
            )
            database.getProductDao().add(
                ProductEntity(
                    0,
                    R.drawable.product_helthy,
                    "Yuz va tana uchun krem Чистая Линия, oziqlantiruvchi va…",
                    "22 000",
                    "16 000",
                    false,
                    false,
                    5
                )
            )
            database.getProductDao().add(
                ProductEntity(
                    0,
                    R.drawable.product_wireless,
                    "Simsiz quloqchinlari Anker soundcore A20i, Bluetooth 5.3",
                    "22 000",
                    "16 000",
                    false,
                    false,
                    4
                )
            )
        }
    }
}