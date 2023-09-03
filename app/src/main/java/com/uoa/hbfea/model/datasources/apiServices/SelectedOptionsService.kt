package com.uoa.hbfea.model.datasources.apiServices

import com.uoa.hbfea.model.models.SelectedOptionsItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface SelectedOptionsService {
    @POST("/safe-drive-ng-api/v1/selected_options/selected-options/")
    suspend fun postSelectedOptions(
        @Body selectedOptions: SelectedOptionsItem,
        @Query("reports_id") reportId: Int
    ): Response<SelectedOptionsItem>
}