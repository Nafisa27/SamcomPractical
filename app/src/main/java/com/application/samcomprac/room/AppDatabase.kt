package com.application.samcomprac.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(ProductModel::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao


    companion object {

        private const val DB_NAME = "product_db"

        @Volatile
        private var sInstance: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
//                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }
}