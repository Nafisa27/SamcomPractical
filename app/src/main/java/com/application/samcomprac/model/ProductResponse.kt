package com.application.samcomprac.model


import com.google.gson.annotations.SerializedName

class ProductResponse : ArrayList<ProductResponse.ProductResponseItem>(){
    data class ProductResponseItem(
        @SerializedName("CustomerEntersPrice")
        val customerEntersPrice: Boolean,
        @SerializedName("DiscountAmount")
        val discountAmount: Double,
        @SerializedName("DiscountPercentage")
        val discountPercentage: Double,
        @SerializedName("DisplayOrder")
        val displayOrder: Int,
        @SerializedName("DisplayStockAvailability")
        val displayStockAvailability: Boolean,
        @SerializedName("DisplayStockQuantity")
        val displayStockQuantity: Boolean,
        @SerializedName("FullDescription")
        val fullDescription: String,
        @SerializedName("Gtin")
        val gtin: String,
        @SerializedName("Id")
        val id: Int,
        @SerializedName("IsGiftCard")
        val isGiftCard: Boolean,
        @SerializedName("ManageInventoryMethodId")
        val manageInventoryMethodId: Int,
        @SerializedName("MaximumCustomerEnteredPrice")
        val maximumCustomerEnteredPrice: Double,
        @SerializedName("MinimumCustomerEnteredPrice")
        val minimumCustomerEnteredPrice: Double,
        @SerializedName("Name")
        val name: String,
        @SerializedName("Price")
        val price: Double,
        @SerializedName("ProductAttributes")
        val productAttributes: List<Any>,
        @SerializedName("ProductCategories")
        val productCategories: String,
        @SerializedName("ProductFullSizePictures")
        val productFullSizePictures: List<Any>,
        @SerializedName("ProductPictures")
        val productPictures: List<Any>,
        @SerializedName("ProductSpecificationAttributes")
        val productSpecificationAttributes: List<Any>,
        @SerializedName("Published")
        val published: Boolean,
        @SerializedName("ShortDescription")
        val shortDescription: String,
        @SerializedName("ShowOnKiosk")
        val showOnKiosk: Boolean,
        @SerializedName("ShowOnPosMobile")
        val showOnPosMobile: Boolean,
        @SerializedName("ShowOnPosWeb")
        val showOnPosWeb: Boolean,
        @SerializedName("ShowOnWebsite")
        val showOnWebsite: Boolean,
        @SerializedName("Sku")
        val sku: String,
        @SerializedName("StockQuantity")
        val stockQuantity: Int,
        @SerializedName("TaxRate")
        val taxRate: Double,
        @SerializedName("UsePercentage")
        val usePercentage: Boolean
    )

}