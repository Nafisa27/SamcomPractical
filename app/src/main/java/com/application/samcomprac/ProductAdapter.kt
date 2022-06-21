package com.application.samcomprac

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.samcomprac.ProductAdapter.UserViewHolder
import com.application.samcomprac.base.BaseViewHolder
import com.application.samcomprac.databinding.ItemProductBinding
import com.application.samcomprac.model.ProductResponse
import com.application.samcomprac.room.ProductModel

class ProductAdapter(
    val productList: MutableList<ProductModel>,
) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.onBind(position)

    override fun getItemCount() = productList.size


    inner class UserViewHolder(binding: ItemProductBinding) : BaseViewHolder(binding.root) {

        private val mBinding: ItemProductBinding = binding

        override fun onBind(position: Int) {
            val product = productList[position]
            mBinding.apply {

                viewModel = product
            }
        }
    }
}