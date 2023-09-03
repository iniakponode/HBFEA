package com.uoa.hbfea.ui.reports

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ReportInstructionsText(){
    // Feedback Type Selection
    Text(
        text = "Welcome to Harsh Breaking Factors Evaluation App (HBFEA)!\n" +
                "Harsh braking is when a driver uses more force than necessary to stop the vehicle.\n" +
                "Harsh braking, together with rapid acceleration and speeding, " +
                "is one of the unsafe driver behaviour patterns.\n" +
                "Please carefully read these instructions:\n" +
                "Observe the items on the following screen with checkboxes. " +
                "These are potential factors linked to harsh braking.\n" +
                "Check the boxes that, in your view, contribute to a driver's likelihood of harsh braking. " +
                "I'll then create a report based on your selections as an AI-powered Safe Driving Assistant.\n" +
                "Additionally, let me know your preferred report type (Quantitative or Qualitative)" +
                " and your insights in the next screen.",
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .border(
                border = BorderStroke(2.dp, Color.Magenta),
                shape = MaterialTheme.shapes.large
            )
            .padding(20.dp),
        fontWeight = FontWeight.Normal,
        style = MaterialTheme.typography.bodyLarge

    )
}