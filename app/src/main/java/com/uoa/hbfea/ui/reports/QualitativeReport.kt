package com.uoa.hbfea.ui.reports

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QualitativeReport(qReport:String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(
                border = BorderStroke(2.dp, Color.Magenta),
                shape = MaterialTheme.shapes.large
            ).fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Qualitative Report",
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )

//            Spacer(modifier = Modifier.height(16.dp))

            val cleanedText = qReport.replace("\\s+".toRegex(), " ").trim() // Remove extra white spaces
            val sentences = cleanedText.split(Regex("(?<=\\.|\\?|!)\\s"))
            sentences.forEachIndexed { index, sentence ->
                val backgroundColor = if (index % 2 == 0) Color.LightGray else Color.White
                val textColor = if (index % 2 == 0) Color.Black else Color.Black
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = backgroundColor
                    ),
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 2.dp
                    )
                ) {
                    Text(
                        text = sentence,
                        modifier = Modifier.padding(16.dp),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Justify,
                        color = textColor
                    )
                }
            }


        }

    }
}

//
//@Composable
//fun FormattedText(inputText: String) {
//
//}