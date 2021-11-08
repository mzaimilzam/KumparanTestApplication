package com.mzaimilzam.kumparantestapplication.presenter.all_post

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mzaimilzam.kumparantestapplication.Screen
import com.mzaimilzam.kumparantestapplication.presenter.all_post.component.ItemListAllPostScreen

/**
 * Created by Muhammad Zaim Milzam on 05/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@Composable
fun AllPostListScreen(
    navController: NavController,
    viewModel: AllPostListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(top = 32.dp)
                )

            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                items(state.result) { result ->
                    ItemListAllPostScreen(
                        allPost = result,
                        onItemClick = {
                            navController.navigate(route = Screen.DetailPostScreen.passtoDetailScreen(
                                username = result.username.toString(),
                                title = result.title.toString(),
                                body = result.body.toString(),
                                postId = result.id.toString(),
                                userId = result.userId.toString()
                            ))
                        }
//                                navController.navigate(Screen.DetailPostScreen.route + "/${result.userId}")
                    )
                }
            }


        }
    }

}