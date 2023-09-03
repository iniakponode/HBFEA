package com.uoa.hbfea.model.datasources.apiServices

import com.uoa.hbfea.model.models.ReportItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ReportService {

    @POST("/safe-drive-ng-api/v1/reports/reports/")
    suspend fun postReport(
        @Body report: ReportItem,
        @Query("user_id") userId: Int
    ): Response<ReportItem>


}