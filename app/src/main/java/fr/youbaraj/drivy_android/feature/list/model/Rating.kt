package fr.youbaraj.drivy_android.feature.list.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Rating (@SerializedName("average") val average: Double,
                   @SerializedName("count") val count: Int) : Serializable
