package com.mzaimilzam.kumparantestapplication.presenter.detail_photo

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mzaimilzam.kumparantestapplication.presenter.components.ArrowBack
import com.mzaimilzam.kumparantestapplication.presenter.components.ZoomableImage

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@ExperimentalCoilApi
@Composable
fun DetailPhotoScreen(
    navController: NavController,
    url: String,
    title: String
) {
    val painter =
        rememberImagePainter("")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ArrowBack(navController = navController)
            ZoomableImage(
                painter = painter,
                isRotation = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
            )
            Text(
                text = "title",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                color = Color.White,
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxHeight(0.3f)
            )
//                Text(
//                    text = title,
//                    style = MaterialTheme.typography.subtitle2,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .fillMaxHeight(0.3f)
//                        .padding(start = 4.dp),
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis,
//                    fontSize = 11.sp,
//                )
        }
    }

}