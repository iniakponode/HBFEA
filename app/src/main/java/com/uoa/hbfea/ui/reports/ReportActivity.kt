package com.uoa.hbfea.ui.reports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.lifecycleScope
import com.uoa.hbfea.model.models.FeaturesModel
import com.uoa.hbfea.model.repositories.UserRepositoryImpl
import com.uoa.hbfea.utility.CompanionFunctions
import kotlinx.coroutines.launch


class ReportActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val selectedOb =
            intent.getSerializableExtra("selectedObjects") as? ArrayList<FeaturesModel>
        val token = intent.getStringExtra("token") as String



        val userRepository= UserRepositoryImpl()

        val userExists= mutableStateOf(false)



        lifecycleScope.launch {
            userExists.value = CompanionFunctions.checkUser(userRepository, token)

        }

        setContent {
//            requestWriteExternalStoragePermission()
                ReportContent(token,selectedOb)

        }
    }

//    private val WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1
//
//    // Request the WRITE_EXTERNAL_STORAGE permission
//    private fun requestWriteExternalStoragePermission() {
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
//            if (ContextCompat.checkSelfPermission(
//                    this,
//                    permission
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf(permission),
//                    WRITE_EXTERNAL_STORAGE_REQUEST_CODE
//                )
//            } else {
//                // Permission already granted
//                Toast.makeText(this, "Permission is Granted", Toast.LENGTH_LONG)
//                // Proceed with file-saving functionality
////                if (showThankYouDialog) {
////                    showThankYouDialog(this@UserFeedBackActivity)
////                }
//            }
//        } else {
//            // Device is running an SDK version lower than Marshmallow
//            Toast.makeText(
//                this,
//                "Device is running an SDK version lower than Marshmallow",
//                Toast.LENGTH_LONG
//            )
//            // Permission is granted by default
//            // Proceed with file-saving functionality
//        }
//    }
//
//    // Handle the permission request result
//    @Suppress("DEPRECATION")
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted
//                Toast.makeText(this, "Permission is Granted", Toast.LENGTH_LONG)
//                // Proceed with file-saving functionality
//            } else {
//                Toast.makeText(this, "Permission is Denied", Toast.LENGTH_LONG)
//                // Handle the case where permission is required for file-saving
//            }
//        }
//    }

    }

