@file:OptIn(ExperimentalMaterial3Api::class)

package com.uoa.hbfea.ui.feedbackComponents

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.uoa.hbfea.MainActivity


@Composable
fun FeedbackForm(token:String,
                 context:Context= LocalContext.current,
//                 report: String,
                 selectedTextQantiRating:String,
                 onSubmit: (String, Boolean, Boolean, String) -> Unit,

) {
    val agree= rememberSaveable{ mutableStateOf(false) }
    val change_b= rememberSaveable {
        mutableStateOf(false)
    }
    val feedbackText=rememberSaveable{ mutableStateOf("") }
    val showThankYouDialog=rememberSaveable{ mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {

           Text(
               text = "Do you agree to the report?",
               fontWeight = FontWeight.SemiBold ,
           )

        Row(horizontalArrangement = Arrangement.SpaceEvenly,modifier = Modifier.padding(bottom = 8.dp)) {

                RadioButton(
                    selected = agree.value,
                    onClick = { agree.value = true },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .align(Alignment.CenterVertically)
                )

                Text(text = "Yes", modifier = Modifier.align(Alignment.CenterVertically))


        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(bottom = 8.dp)) {

                RadioButton(
                    selected = !agree.value,
                    onClick = { agree.value = false },
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .align(Alignment.CenterVertically)
                )

                Text(text = "No",modifier = Modifier.align(Alignment.CenterVertically))
            }



        Text(
            text = "If you drive, can the report make you to be more careful with your selected factors when driving?",
            fontWeight = FontWeight.SemiBold ,
        )

        Row(horizontalArrangement = Arrangement.SpaceEvenly,modifier = Modifier.padding(bottom = 8.dp)) {

            RadioButton(
                selected = change_b.value,
                onClick = { change_b.value = true },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
            )

            Text(text = "Yes", modifier = Modifier.align(Alignment.CenterVertically))


        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(bottom = 8.dp)) {

            RadioButton(
                selected = !change_b.value,
                onClick = { change_b.value = false },
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
            )

            Text(text = "No",modifier = Modifier.align(Alignment.CenterVertically))
        }


        Row(modifier = Modifier.padding(bottom = 8.dp)) {

            Text(
                text = "Share your thoughts. " +
                        "How can I improve the report presentation to influence driver behavior? " +
                        "Also, consider if any of your chosen factors might influence a driver to break speed limits. " +
                        "Anything else you'd like to add?",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Row(modifier = Modifier.padding(bottom = 8.dp)) {

            TextField(
                value = feedbackText.value,
                onValueChange = { feedbackText.value = it },
                label = { Text(text = "Enter your thoughts here.") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

        }

    Row(modifier = Modifier.padding(bottom = 8.dp)) {
        Button(
            onClick = {
                if (agree.value ||change_b.value|| feedbackText.value.isNotEmpty()) {
                    onSubmit(selectedTextQantiRating,agree.value,change_b.value, feedbackText.value)
                    showThankYouDialog.value = true
                } else {
                    Toast.makeText(context,"Please Ensure all fields and radio buttons are filled and checked\n",Toast.LENGTH_LONG).show()
                }},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit Response")
        }
    }


}
    if (showThankYouDialog.value) {
//        appRestartListener=UserFeedBackActivity()

        showThankYouDialog(token,context)

//            navHost.navigate("appMainEntry/$token")

    }
}

private fun showThankYouDialog(token:String,context: Context) {

    val builder = AlertDialog.Builder(context)
    builder.setTitle("Thank You")
    builder.setMessage("Thank you for taking part in this evaluation.\nWe will reach out with further research developments.")
    builder.setPositiveButton("OK") { dialog: DialogInterface, _: Int ->
        dialog.dismiss()
//        navHost.navigate("appMainEntry/$token") // Navigate to EntryFile using the navController)
        navigateToMainActivity(context,token)
//        appRestartListener.restartApp(token, context)
    }

    val dialog = builder.create()
    dialog.show()
}


private fun navigateToMainActivity(context: Context, token: String) {
    val intent = Intent(context, MainActivity::class.java)
    intent.putExtra("temp",token)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK

    context.startActivity(intent)

}


