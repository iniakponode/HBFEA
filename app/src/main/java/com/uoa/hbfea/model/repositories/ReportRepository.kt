package com.uoa.hbfea.model.repositories

import com.uoa.hbfea.model.models.ReportItem
import com.uoa.hbfea.model.models.Result

interface ReportRepository {
    suspend fun generateReport(newReportItem: ReportItem, userId:Int): Result<ReportItem>
}