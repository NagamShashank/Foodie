package com.example.foodie

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RestaurantResponse(
    @SerializedName("rImage") val rImage: String?,
    @SerializedName("rName") val rName: String?,
    @SerializedName("rKilometers") val rKilometers: String?,
    @SerializedName("ratingCount") val ratingCount: String?
):Serializable , Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(rImage)
        parcel.writeString(rName)
        parcel.writeString(rKilometers)
        parcel.writeString(ratingCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RestaurantResponse> {
        override fun createFromParcel(parcel: Parcel): RestaurantResponse {
            return RestaurantResponse(parcel)
        }

        override fun newArray(size: Int): Array<RestaurantResponse?> {
            return arrayOfNulls(size)
        }
    }
}
