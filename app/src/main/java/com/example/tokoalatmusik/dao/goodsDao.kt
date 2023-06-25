package com.example.tokoalatmusik.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tokoalatmusik.model.Goods
import kotlinx.coroutines.flow.Flow

@Dao
interface goodsDao {
@Query("SELECT * FROM `goods_table` ORDER BY name ASC")
        fun getALLGoods(): Flow<List<Goods>>

        @Insert
        suspend fun insertGoods(goods: Goods)

        @Delete
        suspend fun deleteGoods(goods: Goods)

        @Update fun updateGoods(goods: Goods)
}