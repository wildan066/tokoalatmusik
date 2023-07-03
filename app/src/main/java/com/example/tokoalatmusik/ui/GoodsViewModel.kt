package com.example.tokoalatmusik.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tokoalatmusik.model.Goods
import com.example.tokoalatmusik.repository.GoodsRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class goodsViewModel(private val repository: GoodsRepository):ViewModel() {
    val allgoods: LiveData<List<Goods>> = repository.allGoods.asLiveData()

    fun insert(goods: Goods) = viewModelScope.launch {
        repository.deleteGoods(goods)
    }

    fun delete(goods: Goods) =viewModelScope.launch {
        repository.deleteGoods(goods)
    }

    fun update(goods: Goods) = viewModelScope.launch {
        repository.updateGoods(goods)
    }
}

class goodsViewModelFactory(private val repository: GoodsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom((goodsViewModel::class.java))) {
            return goodsViewModel(repository) as T
        }
        throw IllegalArgumentException("unknown ViewModel class")
    }
}