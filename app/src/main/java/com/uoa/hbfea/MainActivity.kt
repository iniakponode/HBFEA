package com.uoa.hbfea

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import com.uoa.hbfea.ui.AppNavHost

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

           AppNavHost()

        }


    }


}