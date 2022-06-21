package com.application.samcomprac.room

import androidx.room.Entity
import androidx.room.PrimaryKey

// Model class is table of room.
@Entity
data class ProductModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String = "",
    var price: Double = 0.0,
)
