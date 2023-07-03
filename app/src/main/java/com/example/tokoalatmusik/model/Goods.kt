package com.example.tokoalatmusik.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "goods_table")
data class Goods (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
            val name: String,
                    val address: String,
                    val jenis: String
) : Parcelable
