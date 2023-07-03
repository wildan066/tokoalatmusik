package com.example.tokoalatmusik.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tokoalatmusik.dao.GoodsDao
import com.example.tokoalatmusik.model.Goods

@Database(entities = [Goods::class], version = 1, exportSchema = false)
abstract class GoodsDatabase:RoomDatabase()  {
abstract fun goodsDao(): GoodsDao

    companion object {
        private var INSTANCE: GoodsDatabase? = null

        fun getDatabase(context: Context): GoodsDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GoodsDatabase::class.java,
                    "goods_database1"
                )
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                instance
            }


        }
    }
}