package com.mzaimilzam.kumparantestapplication.presenter.detail_user.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.mzaimilzam.core.domain.model.Albums
import com.mzaimilzam.kumparantestapplication.Screen
import com.mzaimilzam.kumparantestapplication.presenter.detail_user.DetailUserViewModel

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalCoilApi
@Composable
fun ItemListAlbum(
    albums: Albums,
    navController: NavController,
    viewModel: DetailUserViewModel = hiltViewModel()
) {

    val state = viewModel.statePhoto.value

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Text(text = albums.title.toString())

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                val grouped = state.result.groupBy { it.albumId }
                grouped.forEach { initial, data ->
                    items(data) { result ->
                        ItemListPhoto(
                            navController = navController,
                            photo = result,
                            onItemClick = {
                                navController.navigate(
                                    route = Screen.DetailPhotoScreen.passtoDetailPhotoScreen(
                                        url = result.url.toString(),
                                        title = result.title.toString()
                                    )
                                )
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                }
            }
        }

    }

}