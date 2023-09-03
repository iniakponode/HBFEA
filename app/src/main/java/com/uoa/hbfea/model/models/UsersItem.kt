package com.uoa.hbfea.model.models


import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("userType")
    val userType: String,

    @SerializedName("id")
    val id: Int,
    @SerializedName("reports")
    val reports: List<ReportItem>,
    @SerializedName("token")
    val token: String
)