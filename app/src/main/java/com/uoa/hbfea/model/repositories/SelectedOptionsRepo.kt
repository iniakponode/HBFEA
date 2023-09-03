package com.uoa.hbfea.model.repositories

import com.uoa.hbfea.model.models.Result
import com.uoa.hbfea.model.models.SelectedOptionsItem

interface SelectedOptionsRepo {
    suspend fun postSelectedOpts(newSelectedOptionsItem:SelectedOptionsItem,report_id:Int): Result<SelectedOptionsItem>
}