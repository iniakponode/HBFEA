package com.uoa.hbfea.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.uoa.hbfea.R

import com.uoa.hbfea.utility.CompanionFunctions.Companion.PREFS_NAME
import com.uoa.hbfea.utility.CompanionFunctions.Companion.USER_TOKEN_KEY
import kotlinx.coroutines.delay

@Composable
fun AppStartComposable(onNavigationToAScreen: (String) -> Unit) {

    val prefs = LocalContext.current.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val userToken = prefs.getString(USER_TOKEN_KEY, null)


    // State to track whether the splash screen is done
    val splashScreenDone=remember { mutableStateOf(false) }

//    // Simulate a delay for the splash screen using LaunchedEffect


    // When the splash screen is done, trigger the navigation
    if (splashScreenDone.value) {
        if(userToken!=null) {
            onNavigationToAScreen(userToken.toString())

        }
        else {
            onNavigationToAScreen("NoToken")
        }
        splashScreenDone.value=false
    } else {

        // Show the splash screen UI
            LaunchedEffect(true) {
                    delay(10000) // Delay for 2 seconds (adjust as needed)
                   splashScreenDone.value = true
                }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Display the splash screen image
            Image(
                painter = painterResource(R.drawable.safedrivingsplash), // Replace with your image resource
                contentDescription = "Splash Screen"
            )

        }

    }
}
