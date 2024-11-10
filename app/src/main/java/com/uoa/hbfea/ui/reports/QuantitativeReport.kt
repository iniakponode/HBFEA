package com.uoa.hbfea.ui.reports

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uoa.hbfea.model.models.FeaturesModel

@Composable
fun QuantitativeReportRow(selectedObjects: List<FeaturesModel>?) {

    Column(
        Modifier
            .padding(8.dp)
            .border(
                border = BorderStroke(2.dp, Color.Magenta),
                shape = MaterialTheme.shapes.large
            ).fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Text(
                "Quantitative Report",
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.titleMedium
            )
        }
        FeatureTable(selectedObjects)
    }
}

@Composable
fun FeatureTable(selectedObjects: List<FeaturesModel>?) {
    selectedObjects?.forEachIndexed { index, feature ->
        FeatureCard(
            featureName = feature.name,
            coefficient = feature.coefficient.toString(),
            pValue = feature.pValue.toString(),
            confidenceInterval = feature.confidenceInterval.toString(),
            isEven = index % 2 == 0
        )
    }
}

@Composable
fun FeatureCard(
    featureName: String,
    coefficient: String,
    pValue: String,
    confidenceInterval: String,
    isEven: Boolean
) {
    val cardColor = if (isEven) Color.LightGray else Color.White
    Card(
        colors = CardDefaults.cardColors(
            containerColor = cardColor
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), // Add elevation for a slick appearance
        shape = RoundedCornerShape(8.dp) // Rounded corners
    ) {
        Column(
            modifier = Modifier.padding(2.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HeaderColumn("Influence")
                HeaderColumn("Coefficient")
                HeaderColumn("p-value")
                HeaderColumn("Conf.Int")
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DataColumn(featureName, TextAlign.Left)
                DataColumn(coefficient, TextAlign.Center)
                DataColumn(pValue, TextAlign.Center)
                DataColumn(confidenceInterval, TextAlign.Right)
            }
        }
    }
}

@Composable
fun HeaderColumn(text: String) {
    Column(
        modifier = Modifier
            .border(
                width = 0.4.dp,
                color = Color.White.copy(alpha = 0.4f), // Lighter border color
                shape = RoundedCornerShape(4.dp)
            )
            .background(Color.Black),
    ) {
        Text(
            modifier=Modifier.padding(2.dp),
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.White // Text color
        )
    }
}

@Composable
fun DataColumn(text: String, alignment: TextAlign) {


        Text(
            modifier = Modifier.padding(5.dp),

            text = text,
            textAlign = alignment,
            fontWeight = FontWeight.W600,
            color = Color.Black // Text color
        )
}
