package com.application.samcomprac.base

import androidx.lifecycle.ViewModel
import com.application.samcomprac.network.ApiService
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject
    lateinit var provideApiService: ApiService
}