package com.uoa.hbfea.ui.featureComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uoa.hbfea.model.models.FeaturesModel

@Composable
fun FeaturesImg(featuresModel: FeaturesModel) {
    Image(
        painter = painterResource(id = featuresModel.imageId) ,
        contentDescription ="$featuresModel.name image",
        modifier = Modifier
            .size(35.dp)
            .clip(shape = RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Fit
    )
}