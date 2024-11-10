package com.uoa.hbfea.ui.reports

import com.uoa.hbfea.model.models.FeaturesModel

class NLGEngine {
    companion object{
        fun generateNLGReport(featuresModels: List<FeaturesModel>): Triple<String, String, String> {
            val quantitativeReport = StringBuilder()
            val qualitativeReport = StringBuilder()
            val graphicalReport = StringBuilder()

            val positiveStrongFeatures = mutableListOf<String>()
            val positiveWeakFeatures = mutableListOf<String>()
            val positiveModerateFeatures = mutableListOf<String>()
            val positiveNoSignificance= mutableListOf<String>()
            val negativeStrongFeatures = mutableListOf<String>()
            val negativeModerateFeatures = mutableListOf<String>()
            val negativeWeakFeatures = mutableListOf<String>()
            val negativeNoSignificance=mutableListOf<String>()

            for (featuresModel in featuresModels) {
                quantitativeReport.append("${featuresModel.name} has coefficient: ${featuresModel.coefficient}, p-value: ${featuresModel.pValue}, and CI: ${featuresModel.confidenceInterval}.\n")

                val impactDirection = featuresModel.impact_direction
                val impactStrength = featuresModel.impact_strength
                val pValue = featuresModel.pValue

                if (impactDirection == "Positive") {
                    when {
                        impactStrength == "Strong" && pValue < 0.05 -> positiveStrongFeatures.add(featuresModel.name)
                        impactStrength == "Weak" && pValue < 0.05 -> positiveWeakFeatures.add(featuresModel.name)
                        impactStrength == "Moderate" && pValue < 0.05 -> positiveModerateFeatures.add(featuresModel.name)

                        impactStrength == "Strong" && pValue > 0.05 -> positiveNoSignificance.add(featuresModel.name)
                        impactStrength == "Weak" && pValue > 0.05 -> positiveNoSignificance.add(featuresModel.name)
                        impactStrength == "Moderate" && pValue > 0.05 -> positiveNoSignificance.add(featuresModel.name)
                        else -> continue
                    }
                } else if (impactDirection == "Negative") {
                    when {
                        impactStrength == "Strong" && pValue < 0.05 -> negativeStrongFeatures.add(featuresModel.name)
                        impactStrength == "Moderate" && pValue < 0.05 -> negativeModerateFeatures.add(featuresModel.name)
                        impactStrength == "Weak" && pValue < 0.05 -> negativeWeakFeatures.add(featuresModel.name)

                        impactStrength == "Strong" && pValue > 0.05 -> negativeNoSignificance.add(featuresModel.name)
                        impactStrength == "Moderate" && pValue > 0.05 -> negativeNoSignificance.add(featuresModel.name)
                        impactStrength == "Weak" && pValue > 0.05 -> negativeNoSignificance.add(featuresModel.name)
                        else -> continue
                    }
                }
            }
            formatSummary(qualitativeReport, positiveStrongFeatures, " significantly contribute to the occurrence of Harsh Braking.\n")
            formatSummary(qualitativeReport, positiveNoSignificance, " influence on the risk of increasing the rate of Harsh braking cannot be determined currently.")
            formatSummary(qualitativeReport, positiveWeakFeatures, " contribute weakly to the increase in Harsh Braking.\n")
            formatSummary(qualitativeReport, positiveModerateFeatures, " moderately increase Harsh Braking while driving.\n")

            formatSummary(qualitativeReport, negativeStrongFeatures," on the other hand, significantly decrease Harsh Braking.\n")
            formatSummary(qualitativeReport, negativeNoSignificance, " influence on decreasing the rate of Harsh braking cannot be determined currently.\n")
            formatSummary(qualitativeReport, negativeModerateFeatures," moderately reduce Harsh Braking on the other hand.\n")

            formatSummary(qualitativeReport, negativeWeakFeatures, "slightly decrease Harsh Braking.")

            return Triple(
                quantitativeReport.toString(),
                qualitativeReport.toString(),
                graphicalReport.toString()
            )
        }

        private fun formatSummary(
            report: StringBuilder,
            features: List<String>,
            influenceDescription: String
        ) {
            if (features.isNotEmpty()) {
                for ((index, feature) in features.withIndex()) {
                    report.append(feature)
                    when (index) {
                        features.size - 1 -> {
                            // If it's the last feature, append the influence description
                            report.append(" $influenceDescription")
                        }
                        features.size - 2 -> {
                            // If it's the second-to-last feature, use "and" before the last feature
                            report.append(" and ")
                        }
                        else -> {
                            // For other features, use a comma and space
                            report.append(", ")
                        }
                    }
                }
            }
        }

    }
}