package com.application.samcomprac.network

import com.application.samcomprac.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(APIConstant.API_USERS)
    suspend fun getProductList(): Response<ProductResponse>

}