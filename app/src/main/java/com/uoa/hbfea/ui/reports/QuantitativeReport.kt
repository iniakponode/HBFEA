package com.uoa.hbfea.ui.reports

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import com.uoa.hbfea.model.models.FeaturesModel

@Composable
fun QuantitativeReportRow(selectedObjects: List<FeaturesModel>?) {

    Column(
        Modifier
            .padding(16.dp)
            .border(
                border = BorderStroke(2.dp, Color.Magenta),
                shape = MaterialTheme.shapes.large
            )
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
    // Header
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        HeaderColumn("Influence")
        HeaderColumn("Coefficient")
        HeaderColumn("p-value")
        HeaderColumn("Confid. Interv.")
    }

    // Data rows
    selectedObjects?.forEach { feature ->
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color.LightGray)
        ) {
            DataColumn(feature.name, TextAlign.Left)
            DataColumn(feature.coefficient.toString(), TextAlign.Center)
            DataColumn(feature.pValue.toString(), TextAlign.Center)
            DataColumn(feature.confidenceInterval.toString(), TextAlign.Right)
        }
    }
}

@Composable
fun HeaderColumn(text: String) {
    Column(modifier = Modifier.border(BorderStroke(1.dp, Color.Magenta)).padding(2.dp)) {
        Text(text = text, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun DataColumn(text: String, alignment: TextAlign) {
    Column(modifier = Modifier.border(BorderStroke(1.dp, Color.Magenta)).padding(2.dp),
    ) {
        Text(text, textAlign = alignment, fontWeight = FontWeight.W600)
    }
}