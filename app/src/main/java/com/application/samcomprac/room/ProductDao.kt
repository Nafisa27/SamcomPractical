package com.application.samcomprac.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {

    @Query("Select * FROM `productmodel` ORDER BY id ASC")
    fun getAllTransactions(): LiveData<List<ProductModel>>
    // insert  data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(productModel: ProductModel): Long

    // update.
    @Update
    suspend fun update(productModel: ProductModel)
}
