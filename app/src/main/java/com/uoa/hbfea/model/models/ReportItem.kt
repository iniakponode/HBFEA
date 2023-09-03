package com.uoa.hbfea.model.models


import com.google.gson.annotations.SerializedName

data class ReportItem(
    @SerializedName("agree")
    val agree: Boolean,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("qualitative")
    val qualitative: String,
    @SerializedName("quantitative")
    val quantitative: String,
    @SerializedName("selected_report")
    val selectedReport: String,
    @SerializedName("user_id")
    val userId: Int
)