package com.uoa.hbfea.ui.feedbackComponents

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uoa.hbfea.model.models.ReportItem
import com.uoa.hbfea.model.models.Result
import com.uoa.hbfea.model.models.SelectedOptionsItem
import com.uoa.hbfea.model.models.UsersItem
import com.uoa.hbfea.model.repositories.ReportRepository
import com.uoa.hbfea.model.repositories.ReportRepositoryImpl
import com.uoa.hbfea.model.repositories.SelectedItemsRepoImpl
import com.uoa.hbfea.model.repositories.SelectedOptionsRepo
import com.uoa.hbfea.model.repositories.UserRepository
import com.uoa.hbfea.model.repositories.UserRepositoryImpl
import com.uoa.hbfea.ui.featureComponents.DropDownMenu
import kotlinx.coroutines.launch

@Composable
fun UserResponseForm(token: String, Qualireport: String, Quatireport: String, selectdItems:String) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val userRepositoryImpl = UserRepositoryImpl()
    val reportRepositoryImpl = ReportRepositoryImpl()
    val selectedItemsRepoImpl=SelectedItemsRepoImpl()

    val selectedTextQantiRating = rememberSaveable { mutableStateOf("") }

    val selectUserType= rememberSaveable{mutableStateOf("")}
    Column(Modifier.padding(5.dp)) {
        Text(
            text = "Please give your FEEDBACK in the form, I really need it to improve!",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Who are you?: ${selectUserType.value}",
            modifier = Modifier.padding(vertical = 0.dp),
            fontWeight = FontWeight.W600
        )
        val menuItems = rememberSaveable { listOf("Driver",
                                            "FRSC Official",
                                            "Police with Traffic experience",
                                            "Driving Instructor")}

        DropDownMenu(
            menuItems = menuItems,
            selectedText = "Tap arrow to select",
            onValueChange = { newText ->
                selectUserType.value = newText
            }
        )

        Spacer(modifier = Modifier.height(5.dp))
        val mItems = rememberSaveable{ listOf("Qualitative Report", "Quantitative Report")}
        Text(
            text = "What\'s your preferred report style, tap the arrow: ${selectedTextQantiRating.value}",
            modifier = Modifier.padding(vertical = 0.dp),
            fontWeight = FontWeight.W600
        )
        DropDownMenu(
            menuItems = mItems,
            selectedText = "Tap arrow to select",
            onValueChange = { newText ->
                selectedTextQantiRating.value = newText
            }
        )



        Row(Modifier.padding(5.dp)) {

            FeedbackForm(
                token,
                context = context,
//                report = Qualireport + "\n" + Quatireport,
                selectedTextQantiRating.value,
            ) { selectedTextQantiRating,selectedOption, feedbackText ->
//                    requestWriteExternalStoragePermission(showThankYouDialog)

                coroutineScope.launch {
                    //                        Add User

                    val newUser = UsersItem(
                        createdAt = "",
                        id = 0,
                        reports = emptyList(),
                        token = token,
                        userType = selectUserType.value
                    )
                    val user_id = addUser(
                        userRepositoryImpl,
                        newUser,
                        context
                    )
                    if (user_id >= 1) {
                        // Use the user ID after creating a report to add the user reports
                        val newReportItem = ReportItem(
                            qualitative = Qualireport,
                            quantitative = Quatireport,
                            selectedReport = selectedTextQantiRating,
                            comment = feedbackText,
                            agree = selectedOption,
                            id = 0,
                            createdAt = "",
                            userId = user_id
                        )
                        Log.i("API Response", user_id.toString())

                        // Call the function to add the report
                        val repId=addReport(
                            reportRepositoryImpl,
                            user_id,
                            newReportItem,
                            context = context
                        )

                        if (repId>=1){
//                            If report is added successfully, us that id to add the user selected items
                            val selectedItems=SelectedOptionsItem(
                                id=0,
                                reports_id = repId,
                                select_opt = selectdItems
                            )
                            Log.d("Selected Items",selectdItems)
                            addSelectedItems(selectedItemsRepoImpl,selectedItems,repId,context)
                        }

                    } else {

                        Log.i("API Response", "Record not Added")
//                            Toast.makeText(context,"Failed to Add Record",Toast.LENGTH_LONG)
                    }

                }

//                saveReportAndFormResponses(
//                    context = context,
//                    report,
//                    selectedOption,
//                    selectedTextQantiRating,
//                    feedbackText
//                )

            }


//                showThankYouDialog = true
        }
    }
}

private suspend fun addUser(
    userRepository: UserRepository,
    usersItem: UsersItem,
    context: Context
): Int {
    var userid = -1
    when (val result = userRepository.registerUser(usersItem)) {

        is Result.Success -> {
            val (userId, _) = result.data // Extract the user ID
            userid = userId
            Log.d("API Response", "User added successfully: $userId")

        }

        is Result.Error -> {
            val exception = result.exception
            Log.e("API Response", "Failed to add User", exception)
            // Handle error
            Toast.makeText(context, "Registration Failed", Toast.LENGTH_SHORT).show()

        }
    }

    return userid
}


private suspend fun addSelectedItems(
    selectedItemsRepo: SelectedOptionsRepo,
    selectedOptionsItem: SelectedOptionsItem,
    report_id:Int,
    context: Context
){
    when (val result = selectedItemsRepo.postSelectedOpts(selectedOptionsItem,report_id)) {
        is Result.Success -> {
            Log.d("API Response", "Selected Items added successfully")
            // Selected Items added successfully
            Toast.makeText(context, "Selected Items added successfully", Toast.LENGTH_SHORT).show()
        }

        is Result.Error -> {
            val exception = result.exception
            Log.e("API Response", "Failed to add Selected Items", exception)
            // Handle error
            Toast.makeText(context, "Failed to Selected Items", Toast.LENGTH_SHORT).show()
        }

    }

}

private suspend fun addReport(
    reportRepository: ReportRepository,
    u_id: Int,
    newReportItem: ReportItem,
    context: Context
): Int {

    var reportid = -1
    when (val result = reportRepository.generateReport(newReportItem, u_id)) {
        is Result.Success -> {
            val report = result.data
            reportid=report.id
            Log.d("API Response", "Report added successfully: $report")
            // Report added successfully
            Toast.makeText(context, "Reports Successfully Added", Toast.LENGTH_SHORT).show()
        }

        is Result.Error -> {
            val exception = result.exception
            Log.e("API Response", "Failed to add report", exception)
            // Handle error
            Toast.makeText(context, "Failed to add report", Toast.LENGTH_SHORT).show()
        }

    }
    return reportid
}