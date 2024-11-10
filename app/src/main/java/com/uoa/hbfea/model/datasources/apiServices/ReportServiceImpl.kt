package com.uoa.hbfea.model.datasources.apiServices

import com.uoa.hbfea.model.datasources.apiServices.ReportService
import com.uoa.hbfea.model.models.ReportItem
import retrofit2.Response

class ReportServiceImpl: ReportService {
    override suspend fun postReport(report: ReportItem, userId:Int): Response<ReportItem> {
        return this.postReport(report,userId)
    }
}