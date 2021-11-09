package com.mzaimilzam.kumparantestapplication.presenter.detail_user

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
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
import com.mzaimilzam.kumparantestapplication.presenter.components.ArrowBack
import com.mzaimilzam.kumparantestapplication.presenter.detail_user.component.ItemDetailUser
import com.mzaimilzam.kumparantestapplication.presenter.detail_user.component.ItemListPhoto

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalCoilApi
@Composable
fun DetailUserScreen(
    navController: NavController,
    viewModel: DetailUserViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    val stateAlbumsState = viewModel.stateAlbums.value
    val stateResult = viewModel.stateResult.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
        ) {
            ArrowBack(navController = navController)
            Spacer(modifier = Modifier.height(16.dp))

            state.result?.let { ItemDetailUser(user = it) }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Albums : ",
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.h6,
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                val grouped = stateResult.result.groupBy { it.albumName }

                grouped.forEach { (initial, data) ->
                    stickyHeader {
                        Text(
                            text = initial.toString()
                                .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(MaterialTheme.colors.primary)
                                .padding(bottom = 4.dp)
                        )

                    }
                    items(data) { result ->
                        Spacer(modifier = Modifier.height(8.dp))
                        ItemListPhoto(
                            navController = navController,
                            result = result,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }

                }
            }

            if (stateResult.isLoading || stateAlbumsState.isLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(top = 100.dp),
                    )

                }
            }

        }

    }
}