package com.application.samcomprac

import android.content.Context
import androidx.lifecycle.LiveData
import com.application.samcomprac.model.ProductResponse
import com.application.samcomprac.network.ApiService
import com.application.samcomprac.room.AppDatabase
import com.application.samcomprac.room.ProductModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val appDatabase: AppDatabase)
{
    companion object {
        private var instance: ProductRepository? = null

        fun getInstance(context: Context): ProductRepository? {
            if (instance == null) {
                val appDatabase = AppDatabase.getInstance(context)
                instance = ProductRepository(appDatabase)
            }
            return instance
        }
    }
    suspend fun getUserList(service: ApiService): Response<ProductResponse> {
        return service.getProductList()
    }

    fun insertProduct(productModel: ProductModel) {
        CoroutineScope(Dispatchers.IO).launch {
            appDatabase.productDao().insert(productModel)
        }
    }
    fun getAllTransactions(): LiveData<List<ProductModel>> = appDatabase.productDao().getAllTransactions()
}