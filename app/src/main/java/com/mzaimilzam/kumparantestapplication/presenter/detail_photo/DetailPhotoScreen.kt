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
import com.mzaimilzam.core.domain.model.ResultAlbumList
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
    result: ResultAlbumList
) {
    val painter =
        rememberImagePainter(result.url)

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ArrowBack(navController = navController)
            Text(
                text = result.title.toString()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxHeight(0.3f)
            )

            ZoomableImage(
                painter = painter,
                isRotation = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
            )
        }
    }

}