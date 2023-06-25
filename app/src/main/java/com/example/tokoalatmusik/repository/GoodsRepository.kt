package com.example.tokoalatmusik.repository

import com.example.tokoalatmusik.dao.goodsDao
import com.example.tokoalatmusik.model.Goods
import kotlinx.coroutines.flow.Flow

class GoodsRepository(private val goodsDao: goodsDao) {
    val allGoods: Flow<List<Goods>> = goodsDao.getALLGoods()

    suspend fun insertGoods(goods: Goods){
        goodsDao.insertGoods(goods)
    }
    suspend fun deleteGoods(goods: Goods){
        goodsDao.deleteGoods(goods)
    }
    suspend fun updateGoods(goods: Goods){
        goodsDao.updateGoods(goods)
    }

}