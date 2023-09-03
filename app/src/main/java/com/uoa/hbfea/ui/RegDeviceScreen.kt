package com.uoa.hbfea.ui

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import com.uoa.hbfea.ui.reports.ReportInstructionsText
import com.uoa.hbfea.utility.CompanionFunctions.Companion.PREFS_NAME
import com.uoa.hbfea.utility.CompanionFunctions.Companion.USER_TOKEN_KEY
import com.uoa.hbfea.utility.TokenGenerator.Companion.generateRandomString


//// RegistrationScreen.kt
@Composable
fun RegDeviceScreen(onNavigationToAppMainScreen:(String)->Unit) {
    val generatedToken = remember { mutableStateOf("") }
    val newUserToken = generateRandomString(10)
    val prefs = LocalContext.current.getSharedPreferences(
        PREFS_NAME, Context.MODE_PRIVATE
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ReportInstructionsText()
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            generatedToken.value = newUserToken

            prefs.edit {
                putString(USER_TOKEN_KEY, newUserToken)
                apply() // or commit()
            }

            android.util.Log.i("AppResponse",generatedToken.value)

//             Navigate to the EntryFile composable with the generated token
            onNavigationToAppMainScreen(newUserToken)
//            navController.navigate("AppMainEntry/$newUserToken")
        }) {
            Text(text = "Register and Continue")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Generated Token: ${generatedToken.value}")
    }
}