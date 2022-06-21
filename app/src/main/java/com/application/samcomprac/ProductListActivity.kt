package com.application.samcomprac

import androidx.recyclerview.widget.GridLayoutManager
import com.application.samcomprac.base.BaseActivity
import com.application.samcomprac.databinding.ActivityProductBinding
import com.application.samcomprac.ktx.Logger
import com.application.samcomprac.ktx.gone
import com.application.samcomprac.ktx.isNetworkConnected
import com.application.samcomprac.ktx.visible
import com.application.samcomprac.room.ProductModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity : BaseActivity<ActivityProductBinding, ProductListViewModel>() {
    override val layoutId = R.layout.activity_product
    override val bindingVariable = BR.listViewModel

    lateinit var adapter: ProductAdapter

    override fun setUpObserver() {
        mViewModel.userResponseObservable.observe(this) {

            binding.apply {
                progressCircular.gone()
                for (i in it.indices) {
                    mViewModel.insertProduct(ProductModel(id = i, name = it[i].name, price = it[i].price,))
                }
            }

            Logger.d("UserResponse $it")
        }
        mViewModel.getAllTransactions()?.observe(this){
            Logger.e("All Records $it")
            binding.progressCircular.gone()
            if(!it.isNullOrEmpty()) {
                Logger.d("not empty")
                adapter =
                    ProductAdapter(it.toMutableList() ?: mutableListOf())
                binding.rvUsers.adapter = adapter
            }else
            {
                Logger.e(" empty")
                callUserListApi()
            }
        }
    }

    override fun init() {
        binding.apply {
            rvUsers.layoutManager = GridLayoutManager(this@ProductListActivity, 2)

        }

    }

    private fun callUserListApi() {
        if (isNetworkConnected()) {
            binding.progressCircular.visible()
            mViewModel.getProductList()
        } else {
            showSnackbar("Internet is not connected...")
        }
    }


}