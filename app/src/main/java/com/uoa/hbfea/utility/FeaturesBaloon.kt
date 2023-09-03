package com.uoa.hbfea.utility

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.uoa.hbfea.R
import com.uoa.hbfea.model.models.FeaturesModel

@Composable
fun FeaturesBalloon(featuresModel: FeaturesModel) {

    // create and remember a builder of Balloon.
    val builder = rememberBalloonBuilder {
        setArrowSize(10)
        setArrowPosition(0.5f)
        setArrowPositionRules(ArrowPositionRules.ALIGN_ANCHOR)
        setArrowOrientation(ArrowOrientation.BOTTOM)
        setWidth(BalloonSizeSpec.WRAP)
        setHeight(BalloonSizeSpec.WRAP)
        setPadding(12)
        setMarginHorizontal(12)
        setCornerRadius(8f)
        setBackgroundColorResource(R.color.white)
        setBalloonAnimation(BalloonAnimation.ELASTIC)
    }
    Balloon(
//        modifier=Modifier.align(Alignment.Center),
        builder = builder,
        balloonContent = {
            Text(text =featuresModel.desc)
        }
    ) { balloonWindow ->
        Button(
            modifier = Modifier.size(179.dp, 50.dp),
            colors = ButtonDefaults.buttonColors(Color.hsl(263f, 0.50f, 0.84f)),
            onClick = {
                balloonWindow.showAlignTop() // display your balloon.
            }
        ) {
            Text(
                text = featuresModel.name,
                color= Color.Black,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}