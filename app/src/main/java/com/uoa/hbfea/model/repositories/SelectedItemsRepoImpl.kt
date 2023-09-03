package com.uoa.hbfea.model.repositories

import android.util.Log
import com.uoa.hbfea.model.datasources.apiServices.RetrofitInstance
import com.uoa.hbfea.model.datasources.apiServices.SelectedOptionsService
import com.uoa.hbfea.model.models.SelectedOptionsItem
import com.uoa.hbfea.model.models.Result

class SelectedItemsRepoImpl: SelectedOptionsRepo {
    private val apiService = RetrofitInstance.getRetrofitInstance().create(SelectedOptionsService::class.java)
    override suspend fun postSelectedOpts(
        newSelectedOptionsItem: SelectedOptionsItem,
        report_id: Int
    ): Result<SelectedOptionsItem> {

        return try {
            Log.d("SelectedItems", "New Selected Items: $newSelectedOptionsItem , for report $report_id")
            val response = apiService.postSelectedOptions(newSelectedOptionsItem,report_id)

            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error(Exception("Failed to add SelectedItems"))
            }
        } catch (e: Exception) {
            Log.e("API Response", "Failed", e)
            Result.Error(e)
        }
    }
}