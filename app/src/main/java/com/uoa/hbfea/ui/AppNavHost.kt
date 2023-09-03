package com.uoa.hbfea.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.uoa.hbfea.EntryFile

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = "homeScreen") {

        composable("homeScreen") {
            AppStartComposable(onNavigationToAScreen={

                    if (it!="NoToken"){
                        navController.navigate("appMainEntry/$it")
                    }
                else{
                        Log.d("AppResponse",it)
                        navController.navigate("register_device")

                    }
            })
        }

//        composable("feedbForm/{token}",
//            arguments = listOf(
//                navArgument("feedbForm") {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            FeedbackForm(
//                token = it.arguments?.getString("token").toString(),
//                report = "",
//                selectedTextQantiRating = "",
//                selectedTextQanliRating = "",
//                navController = navController,
//            ) { report, selectedTextQantiRating, selectedTextQanliRating, selectedOption, feedbackText ->
//            }
//
//
//            navController.navigate("appMainEntry/{token}")
//        }

        composable(
            route = "appMainEntry/{token}",
            arguments = listOf(
                navArgument("token"){
                    type = NavType.StringType
                }
            )
        ) {
            EntryFile(
                token = it.arguments?.getString("token").toString(),

            )
        }

        composable("register_device") {
            RegDeviceScreen(
                onNavigationToAppMainScreen = {
                    navController.navigate("appMainEntry/$it")
                }
            )
        }
    }
}
