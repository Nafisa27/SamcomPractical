package com.application.samcomprac

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.application.samcomprac.base.BaseViewModel
import com.application.samcomprac.model.ProductResponse
import com.application.samcomprac.network.APIConstant
import com.application.samcomprac.room.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class ProductListViewModel @Inject constructor(private val context: Context) : BaseViewModel() {

    val userResponseObservable: MutableLiveData<ProductResponse> = MutableLiveData()

    fun getProductList() {
        var response: Response<ProductResponse>? = null
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                response = ProductRepository.getInstance(context)?.getUserList(provideApiService)
            }
            withContext(Dispatchers.Main) {
                response?.run {
                    if (isSuccessful && code() == APIConstant.STATUS_SUCCESS)
                        userResponseObservable.postValue(this.body())
                }
            }
        }
    }
    fun insertProduct(productModel: ProductModel) {
        ProductRepository.getInstance(context)?.
        insertProduct(productModel)
    }
    fun getAllTransactions(): LiveData<List<ProductModel>>? {
        return ProductRepository.getInstance(context)?.getAllTransactions()
    }
}