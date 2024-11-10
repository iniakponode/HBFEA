package com.uoa.hbfea.ui.reports

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.uoa.hbfea.model.models.FeaturesModel
import com.uoa.hbfea.ui.feedbackComponents.UserResponseForm
import com.uoa.hbfea.utility.BaloonBuilder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReportContent(tok:String, selectedObjects: List<FeaturesModel>?) {
    val quantitativeReport = remember { mutableStateOf("") }
    val qualitativeReport = remember { mutableStateOf("") }
    val graphicalReport = remember { mutableStateOf("") }

//    val selectedObjects =
//        intent.getSerializableExtra("selectedObjects") as? ArrayList<FeaturesModel>
//    val token=intent.getStringExtra("token") as String

    val generateReport = {
        val report = NLGEngine.generateNLGReport(selectedObjects!!)
        quantitativeReport.value = report.first
        qualitativeReport.value = report.second
        graphicalReport.value = report.third
    }
    val namesList = selectedObjects?.map { it.name }
    val commaSelectedNames = namesList?.joinToString(", ")



    LaunchedEffect(Unit) {
        generateReport()
        Log.v("Generated", quantitativeReport.value)
        Log.v("Generated", qualitativeReport.value)
        Log.v("Generated",graphicalReport.value)
    }

    Column(Modifier.padding(16.dp).verticalScroll(rememberScrollState()).fillMaxSize()) {

//               UserFeedBackNavButton(token =token, quantitativeReport =qualitativeReport.value , qualitativeReport =qualitativeReport.value )
//        // Summary Report Card
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp).fillMaxSize()) {
                    Text(
                        text = "(My Summary Report for You.)",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .border(
                                border = BorderStroke(2.dp, Color.Magenta),
                                shape = MaterialTheme.shapes.large
                            )
                            .padding(20.dp),
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    BaloonBuilder.KeyTermsBaloony()

                    QuantitativeReportRow(selectedObjects!!)
                    QualitativeReport(qualitativeReport.value)

//

                }
            }
        }
        if (tok !== "")
            UserResponseForm(
                token = tok,
                Qualireport = qualitativeReport.value,
                Quatireport = quantitativeReport.value,
                commaSelectedNames!!
            )
    }

}