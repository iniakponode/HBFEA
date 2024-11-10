package com.uoa.hbfea.utility

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.skydoves.balloon.ArrowOrientation
import com.skydoves.balloon.ArrowPositionRules
import com.skydoves.balloon.BalloonAnimation
import com.skydoves.balloon.BalloonSizeSpec
import com.skydoves.balloon.compose.Balloon
import com.skydoves.balloon.compose.rememberBalloonBuilder
import com.uoa.hbfea.R

class BaloonBuilder {
    companion object {

        @Composable
        fun KeyTermsBaloony() {
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

                builder = builder,
                balloonContent = {
                    Text(
                        text = "Terms and Meaning\n " +
                                "Influence: What could make a driver have a harsh braking event.\n" +
                                "\nCoefficient: The score given to driving behaviors.\n" +
                                "Higher score means more impact on harsh braking rate. \n" +
                                "Conf. Int.(Confidence Interval): The score range we are 95% sure contains the true score for the behaviors.\n" +
                                "p-value: Tells if the score is real or by chance.\nLower value (near 0.000) means we are very sure that the effect is real.",
                        textAlign = TextAlign.Justify,
                        fontWeight = FontWeight.W400,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            ) { balloonWindow ->
                Button(
                    modifier = Modifier.size(320.dp, 80.dp),
                    colors = ButtonDefaults.buttonColors(Color.hsl(263f, 0.50f, 0.84f)),
                    onClick = {
                        balloonWindow.showAlignTop() // display your balloon.
                    }
                ) {
                    Text(
                        text = "Tap to see what P-Value, Coefficient\n and Conf. Int. mean",
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}