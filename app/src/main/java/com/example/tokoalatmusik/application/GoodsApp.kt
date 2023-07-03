package com.example.tokoalatmusik.application

import android.app.Application
import com.example.tokoalatmusik.repository.GoodsRepository

class GoodsApp: Application() {
    val database by lazy { GoodsDatabase.getDatabase(this) }
    val repository by lazy { GoodsRepository(database.goodsDao()) }
}