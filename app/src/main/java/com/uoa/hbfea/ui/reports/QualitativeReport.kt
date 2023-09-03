package com.uoa.hbfea.ui.reports

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun QualitativeReport(qReport:String){
    Column(
        Modifier
            .padding(16.dp)
            .border(
                border = BorderStroke(2.dp, Color.Magenta),
                shape = MaterialTheme.shapes.large
            )) {

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Text(
                "Qualitative Report",
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.titleMedium
            )
        }

        Row(

            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(
                text = qReport,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.W600,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}