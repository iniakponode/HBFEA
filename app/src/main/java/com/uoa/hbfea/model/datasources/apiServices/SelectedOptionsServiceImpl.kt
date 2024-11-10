package com.uoa.hbfea.model.datasources.apiServices

import com.uoa.hbfea.model.datasources.apiServices.SelectedOptionsService
import com.uoa.hbfea.model.models.SelectedOptionsItem
import retrofit2.Response

class SelectedOptionsServiceImpl:SelectedOptionsService {
    override suspend fun postSelectedOptions(
        selectedOptions: SelectedOptionsItem,
        reportId: Int
    ): Response<SelectedOptionsItem> {
        return this.postSelectedOptions(selectedOptions,reportId)
    }
}
