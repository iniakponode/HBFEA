package com.uoa.hbfea.model.models


import com.google.gson.annotations.SerializedName

data class SelectedOptionsItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("reports_id")
    val reports_id: Int,
    @SerializedName("select_opt")
    val select_opt: String
)