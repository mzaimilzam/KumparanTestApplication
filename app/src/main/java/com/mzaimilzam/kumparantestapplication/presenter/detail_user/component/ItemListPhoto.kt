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
import com.mzaimilzam.core.domain.model.Photo

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@ExperimentalCoilApi
@Composable
fun ItemListPhoto(
    navController: NavController,
    photo: Photo,
    onItemClick: (Photo) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClick(photo) }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = rememberImagePainter(
                    data = photo.thumbnailUrl,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = photo.id.toString(),
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
                text = photo.title.toString(),
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .width(120.dp)
                    .padding(start = 4.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
            )
        }
    }
}