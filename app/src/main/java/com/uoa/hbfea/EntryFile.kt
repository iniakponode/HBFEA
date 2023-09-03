package com.uoa.hbfea

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.uoa.hbfea.model.datasources.localStorage.FeaturesList
import com.uoa.hbfea.model.models.FeaturesModel
import com.uoa.hbfea.model.repositories.UserRepositoryImpl
import com.uoa.hbfea.ui.featureComponents.FeaturesImg
import com.uoa.hbfea.ui.reports.ReportActivity
import com.uoa.hbfea.utility.CompanionFunctions.Companion.checkUser
import com.uoa.hbfea.utility.FeaturesBalloon

@Composable
fun EntryFile(token:String, context: Context = LocalContext.current) {

//    val selectedObjects = rememberSaveable{ mutableStateListOf<FeaturesModel>() }
    val selectedObjects = remember { mutableStateListOf<FeaturesModel>() }
    val userRepository=UserRepositoryImpl()

    val userExists=remember { mutableStateOf(false) }


    LaunchedEffect(userRepository) {
        userExists.value = checkUser(userRepository, token)
//        Log.i("App-C", userExists.value.toString())
        if (!userExists.value){
            Toast.makeText(context, "Welcome ${token}!\nThank you for testing me.", Toast.LENGTH_LONG).show()
        }
    }


    selectedObjects.clear()
//    var selectedObjects = remember { mutableStateListOf<FeaturesModel>() }



    val featuresModel = rememberSaveable { FeaturesList.featuresModels }
    Column {

        Text(
//            textAlign = Alignment.Center,


            text = "The listed below are reported factors that influence the tendency for Harsh braking?\n" +
                    " Tick your perceived factors, Tap \'Generate Report\' when done to get my report on your choices.\nTo see more please Scroll Down.\n" +
                    "Tap a button to see its description.",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
                .border(border = BorderStroke(2.dp, Color.Magenta), shape = ShapeDefaults.Large)
                .padding(20.dp),
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Center
        ) {
            ExtendedFloatingActionButton(

                onClick = {
                        if (userExists.value) {
                            // User exists, show a message or handle accordingly
                            Toast.makeText(context, "You can only participate once.\n Thank you for participating!", Toast.LENGTH_LONG).show()
                        } else {


                            if (selectedObjects.isNotEmpty()) {
                                // Log.i("MY", selectedObjects[0].explanation)
                                val intent = Intent(context, ReportActivity::class.java)
                                intent.putExtra("selectedObjects", ArrayList(selectedObjects))
                                intent.putExtra("token", token)
                                context.startActivity(intent)
                            } else {
                                // Handle the case where selectedObjects is empty
                            }

                        }




                },
                icon = {
                    Icon(
                        Icons.Filled.ArrowForward,
                        contentDescription = "Favorite"
                    )
                },
                text = {
                    if (userExists.value)
                        Text(text = "Thank you for Participating!.\nYour response was taken successfully.")
                    else
                        Text(text = "Generate Report")


                },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterEnd)
                    .fillMaxWidth()


            )
        }

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(
                items=featuresModel,
                itemContent={
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        FeaturesImg(featuresModel = it)
                        Checkbox(
                            checked = selectedObjects.contains(it),
                            onCheckedChange = { isChecked ->
                                if (isChecked) {
                                    selectedObjects.add(it)
                                } else {
                                    selectedObjects.remove(it)
                                }
                            }
                                    // Reset the selected checkboxes when the application starts
                        )

                                FeaturesBalloon(it)

//
                    }


                }
            )

        }
    }


}