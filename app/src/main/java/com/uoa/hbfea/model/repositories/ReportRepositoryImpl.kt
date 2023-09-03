package com.uoa.hbfea.model.repositories

import android.util.Log
import com.uoa.hbfea.model.datasources.apiServices.ReportService
import com.uoa.hbfea.model.datasources.apiServices.RetrofitInstance
import com.uoa.hbfea.model.models.ReportItem
import com.uoa.hbfea.model.models.Result

class ReportRepositoryImpl: ReportRepository {
    private val apiService = RetrofitInstance.getRetrofitInstance().create(ReportService::class.java)

    override suspend fun generateReport(newReportItem: ReportItem, userId:Int): Result<ReportItem> {


            return try {
                Log.d("ReportRepoImpl", "New Report Item: $newReportItem , for user $userId")
                val response = apiService.postReport(newReportItem,userId)

                if (response.isSuccessful) {
                    Result.Success(response.body()!!)
                } else {
                    Result.Error(Exception("Failed to add Report"))
                }
            } catch (e: Exception) {
                Log.e("API Response", "Failed", e)
               Result.Error(e)
            }
    }


}