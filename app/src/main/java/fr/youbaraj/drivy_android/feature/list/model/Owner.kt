package fr.youbaraj.drivy_android.feature.list.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Owner(@SerializedName("name") val name: String,
                 @SerializedName("picture_url") val picture: String,
                 @SerializedName("rating") val rating: Rating) : Serializable
