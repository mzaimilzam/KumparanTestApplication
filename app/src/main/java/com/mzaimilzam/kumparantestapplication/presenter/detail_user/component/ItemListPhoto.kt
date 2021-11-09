package com.mzaimilzam.kumparantestapplication.presenter.detail_user.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mzaimilzam.core.domain.model.ResultAlbumList
import com.mzaimilzam.kumparantestapplication.DETAIL_PHOTO_SCREEN_PHOTO
import com.mzaimilzam.kumparantestapplication.Screen

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@ExperimentalCoilApi
@Composable
fun ItemListPhoto(
    navController: NavController,
    result: ResultAlbumList,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { gotoPhotoDetail(result, navController) }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberImagePainter(
                    data = result.thumbnailUrl,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = result.id.toString(),
                modifier = Modifier
                    .size(120.dp)
                    .clip(
                        RoundedCornerShape(
                            8.dp
                        )
                    )
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = result.title.toString()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .width(120.dp)
                    .padding(start = 4.dp)
                    .fillMaxWidth(),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
            )
        }
    }
}

fun gotoPhotoDetail(result: ResultAlbumList, navController: NavController) {
    navController.currentBackStackEntry?.arguments?.putParcelable(DETAIL_PHOTO_SCREEN_PHOTO, result)
    navController.navigate(Screen.DetailPhotoScreen.route)
}