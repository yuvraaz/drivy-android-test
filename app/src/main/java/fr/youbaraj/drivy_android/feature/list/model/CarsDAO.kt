package fr.youbaraj.drivy_android.feature.list.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CarsDAO(@SerializedName("brand") val brand: String,
                   @SerializedName("model") val model: String,
                   @SerializedName("picture_url") val pictureurl: String,
                   @SerializedName("price_per_day") val price: Int,
                   @SerializedName("rating") val rating: Rating,
                   @SerializedName("owner") val owner: Owner): Serializable