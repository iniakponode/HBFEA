package com.uoa.hbfea.model.datasources.localStorage

import com.uoa.hbfea.R
import com.uoa.hbfea.model.models.FeaturesModel

object FeaturesList {

    val featuresModels = listOf(

        FeaturesModel(
            id = 1,
            name = "Alcohol",
            desc="Taking alcohol few minutes before or while driving is reported to influence Harsh Braking?\n Tick Box if you also think so.",
            imageId = R.drawable.alcohol,
            coefficient = 0.4629,
            confidenceInterval=0.170 to 0.756,
            pValue=0.002,
            impact_direction= "Positive",
            impact_strength= "Moderate",
            explanation="We found a 0.4629 coefficient,95% confidence interval of 0.170 to 0.756 and a p-value of 0.002 for alcohol.\n" +
                    "This indicates that alcohol intake just before or while driving increases harsh barking in a positive to moderately strong way."
        ),
        FeaturesModel(
            id = 2,
            name = "Phone",
            desc="Using phone while driving is reported to influence the rate Harsh Braking events?\n Tick Box if you also think so.",
            imageId = R.drawable.phone_icon,
            coefficient = 1.0639,
            confidenceInterval=0.769 to 1.359,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Strong",
            explanation="There is a 1.0639 coefficient, 95% confidence interval of 0.769 to 1.359 with pValue = 0.000 for Phone use while driving.\n" +
                    "This means that on average, use of Phone while driving increase the expected rate of is , indicating that,\n" +
                    " on average, use of phone while driving increases the rate of Harsh Braking with moderately positive to relatively strong effect."),
        FeaturesModel(
            id = 3,
            name = "Bad road",
            desc="Bad Road is reported to influence drivers tendency to Harsh Braking?\n Tick Box if you also think so.",
            imageId = R.drawable.bad_road_icon,
            coefficient = 0.3469,
            confidenceInterval=0.015 to 0.678,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Moderate",
            explanation="We discovered a  coefficient of 0.3469, confidenceInterval of 0.015 to 0.678 and PValue of 0.000.\n" +
                    "What this means is that, the ability of driving on bad roads to increase Harsh Braking could range from weak to moderately positive"
        ),
        FeaturesModel(
            id = 4,
            name = "Overloading",
            desc="An overloaded vehicle is reported to influence the rate of Harsh Braking?\n Tick Box if you also think so.",
            imageId = R.drawable.overaloading_icon,
            coefficient = 1.2538,
            confidenceInterval=0.994 to 1.514,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Strong",
            explanation="There is a 1.2538 coefficient, 0.994 to 1.514 confidence interval and 0.000 PValue.\n" +
                    "This shows that the effect of overloading on Harsh braking could significantly range from moderately positive to relatively strong."
        ),
        FeaturesModel(
            id = 5,
            name = "Night driving",
            desc="It is reported that driving in the night could influence the rate of Harsh Braking? Tick Box if you also think so.",
            imageId = R.drawable.night_driving_icon,
            coefficient = -1.3739,
            confidenceInterval=-2.117 to -0.631,
            pValue=0.000,
            impact_direction= "Negative",
            impact_strength= "Strong",
            explanation="There is a -1.3739 coefficient, -2.117 to -0.631 confidence interval and 0.000 PValue.\n" +
                    "It implies that night driving could negatively and moderately reduce harsh braking relatively strongly"
        ),
        FeaturesModel(
            id = 6,
            name = "Rash driving",
            desc="Driving in a hurry is one of the reported factors that influences the rate of Harsh braking?\n Tick Box if you also think so.",
            imageId = R.drawable.rash_icon,
            coefficient = 2.3053,
            confidenceInterval=1.952 to 2.658,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Strong",
            explanation="There is a 2.3053 coefficient, 1.952 to 2.658 confidence interval and 0.000 PValue.\n" +
                    "It implies that the rash driving (driving in a hurry) positively and strongly increases the chances of harsh braking."
        ),
        FeaturesModel(
            id = 7,
            name = "Unstable mind",
            desc="Driving with an unstable mind is reported to influence Harsh Braking?\n Tick Box if you also think so.",
            imageId = R.drawable.unstable_mind_icon,
            coefficient = 1.3351,
            confidenceInterval=0.611 to 2.060,
            impact_direction= "Positive",
            impact_strength= "Strong",
            pValue=0.000,
            explanation="There is a 1.3351 coefficient, 0.611 to  2.060 confidence interval and 0.000 PValue.\n" +
                    "It implies that the effect of an unstable mind on Harsh Braking could range from moderately positive to relatively strong."
        ),
        FeaturesModel(
            id = 8,
            name = "Tiredness",
            desc="Rate of Harsh Braking is reported to be influenced when driving with tiredness?\n Tick Box if you also think so.",
            imageId = R.drawable.tirednes_icon,
            coefficient = -0.0963,
            impact_direction= "Negative",
            impact_strength= "Weak",
            confidenceInterval=-0.596 to 0.403,
            pValue=0.706,
            explanation="There is a weak negative effect on the expected rate of Harsh Braking for individuals experiencing Tiredness while driving.\n" +
                    "This is because this driving behaviour influence has a 1.3351 coefficient, 0.611 to  2.060 at 95% confidence interval and 0.706 PValue.\n" +
                    "Which means that this is not statistically significant at the 5% level.\n" +
                    "Therefore, we cannot conclude with confidence that there is a true effect of Tiredness on the rate of Harsh Braking."
        ),
        FeaturesModel(
            id = 9,
            name = "Distraction",
            desc="Rate of Harsh Braking is reported to be influenced when distracted while driving?\n Tick Box if you also think so.",
            imageId = R.drawable.distracted_driving_icon,
            coefficient=  1.5911,
            confidenceInterval= 1.280 to  1.280,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Strong",
            explanation = "There is a 1.5911 coefficient, 1.280 to 1.280 confidence interval and 0.000 PValue.\n" +
                    " It implies that the effect of being distracted including music on Harsh Braking is positive and relatively strong."
        ),
        FeaturesModel(
            id = 9,
            name = "Traffic",
            desc="Suddenly meeting a traffic on the road is reported to have influence on Harsh braking?\n Tick Box if you also think so.",
            imageId = R.drawable.traffic_icon,
            coefficient = 1.0850,
            confidenceInterval=0.400 to 1.770,
            pValue=0.002,
            impact_direction= "Positive",
            impact_strength= "Strong",
            explanation="There is a 1.0850 coefficient, 0.400 to 1.770 confidence interval and 0.002 PValue.\n" +
                    "It implies that the effect of traffic on Harsh Braking is positive,\n" +
                    "but the magnitude of the effect may vary within the given range at 95% of the confidence interval range."
        ),
        FeaturesModel(
            id = 10,
            name = "Excitement",
            desc="Extreme happiness is reported to influence Harsh Braking?\n Tick Box if you also think so.",
            imageId = R.drawable.excited_man_icon,
            coefficient = 2.1377,
            confidenceInterval=1.474 to 2.801,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Strong",
            explanation="There is a 2.1377 coefficient, 1.474 to 2.801 confidence interval and 0.000 PValue.\n" +
                    "The confidence interval suggests that with a 95% confidence, the true coefficient value lies within this range.\n" +
                    "It implies that the effect of excitement on Harsh Braking is strongly positive."
        ),
        FeaturesModel(
            id = 11,
            name = "New driver",
            desc="New drivers are reported to have more harsh braking events?\n Tick Box if you also think so. ",
            imageId = R.drawable.new_driver_icon,
            coefficient = 1.4494,
            confidenceInterval=1.286 to 1.613,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Moderate",
            explanation="There is a 1.4494 coefficient, 1.286  to 1.613 confidence interval and 0.000 PValue.\n" +
                    "The confidence interval suggests that with a 95% confidence, the true coefficient value lies within that range.\n" +
                    "Indicating that, on average, there is a positive effect on the expected rate of Harsh Braking for new drivers."
        ),
        FeaturesModel(
            id = 12,
            name = "Urban driving",
            desc="Driving within a town is reported to influence the rate of Harsh Braking?\n Tick Box if you also think so.",
            imageId = R.drawable.urban_driving_icon,
            coefficient = 1.2777,
            confidenceInterval=0.480 to 2.075,
            pValue=0.002,
            impact_direction= "Positive",
            impact_strength= "Moderate",
            explanation="There is a 1.2777 coefficient, 0.480  to 2.075 confidence interval and 0.002 PValue.\n" +
                    "The confidence interval suggests that with a 95% confidence, the true coefficient value lies within that range.\n" +
                    "Indicating that, on average, there is a positive effect on the expected rate of Harsh Braking for individuals driving in urban areas.\n" +
                    "But the magnitude of the effect may vary within the given 95% confidence interval range."
        ),
        FeaturesModel(
            id = 12,
            name = "Rural driving",
            desc="Driving within a village is reported to influence the rate of Harsh Braking?\n Tick Box if you also think so.",
            imageId = R.drawable.rural_driving_icon,
            coefficient = -0.0517,
            confidenceInterval=-0.658 to 0.555,
            pValue=0.867,
            impact_direction= "Negative",
            impact_strength= "Weak",
            explanation="There is a -0.0517 coefficient, -0.658  to -0.658 confidence interval and 0.867 PValue,\n" +
                    "indicating that, on average, there is a weak negative effect on the expected rate of Harsh Braking for individuals driving in rural areas.\n" +
                    "However, the coefficient is close to zero, and the confidence interval includes zero,\n" +
                    " which suggests that the effect of rural driving on Harsh Braking may not be statistically significant."

        ),
        FeaturesModel(
            id = 13,
            name = "Tricycle drivers",
            desc="Driving within tricycle (Keke) crowded places is reported to influence the rate of Harsh braking?\n Tick Box if you also think so.",
            imageId = R.drawable.tricycle_icon,
            coefficient = 2.3973,
            confidenceInterval=1.825 to 2.970,
            pValue=0.000,
            impact_direction= "Positive",
            impact_strength= "Strong",
            explanation="There is a 2.3973 coefficient, 1.825  to 2.970 confidence interval and 0.000 PValue.\n" +
                    "The confidence interval suggests that with a 95% confidence, the true coefficient value lies within this range.\n" +
                    "It implies there is a very high chance of an increase in Harsh Braking events for a vehicle driver that is driving within a road where there are Tricycle Drivers."
        )

    )

//    [
//    {'feature_name': 'fatigue_deasi_tired', },
//    {'feature_name': 'rural_driving', 'impact_direction': 'Negative', 'impact_strength': 'Weak'},
//    {'feature_name': 'urban_driving', 'impact_direction': 'Positive', 'impact_strength': 'Moderate'},
//    {'feature_name': 'traffic', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'bad_road', 'impact_direction': 'Positive', 'impact_strength': 'Moderate'},
//    {'feature_name': 'excitement', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'unstable_mind', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'tricycle_drivers', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'alcohol', 'impact_direction': 'Positive', 'impact_strength': 'Moderate'},
//    {'feature_name': 'rash', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'distr_listen_loud_music', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'nigt_driving', 'impact_direction': 'Negative', 'impact_strength': 'Strong'},
//    {'feature_name': 'phone', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'overloading', 'impact_direction': 'Positive', 'impact_strength': 'Strong'},
//    {'feature_name': 'kilometers', 'impact_direction': 'Negative', 'impact_strength': 'Strong'},
//    {'feature_name': 'new_driver', 'impact_direction': 'Positive', 'impact_strength': 'Moderate'},
//    {'feature_name': 'harshBraking', 'impact_direction': 'Positive', 'impact_strength': 'Strong'}
//    ]


}