package com.uoa.hbfea.model.models

import android.os.Parcel
import android.os.Parcelable

data class FeaturesModel(
    val id: Int,
    val name: String,
    val desc: String,
    val imageId: Int,
    val coefficient: Double,
    val confidenceInterval: Pair<Double, Double>,
    val pValue: Double,
    val explanation: String,
    val impact_direction: String,
    val impact_strength: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble() to parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeInt(imageId)
        parcel.writeDouble(coefficient)
        parcel.writeDouble(confidenceInterval.first)
        parcel.writeDouble(confidenceInterval.second)
        parcel.writeDouble(pValue)
        parcel.writeString(explanation)
        parcel.writeString(impact_direction)
        parcel.writeString(impact_strength)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FeaturesModel> {
        override fun createFromParcel(parcel: Parcel): FeaturesModel {
            return FeaturesModel(parcel)
        }

        override fun newArray(size: Int): Array<FeaturesModel?> {
            return arrayOfNulls(size)
        }
    }
}