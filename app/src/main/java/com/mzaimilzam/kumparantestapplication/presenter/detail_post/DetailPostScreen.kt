package com.mzaimilzam.kumparantestapplication.presenter.detail_post

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mzaimilzam.core.domain.model.ResultListAllPost
import com.mzaimilzam.kumparantestapplication.Screen
import com.mzaimilzam.kumparantestapplication.presenter.components.ArrowBack
import com.mzaimilzam.kumparantestapplication.presenter.detail_post.component.DetailPostTopSection
import com.mzaimilzam.kumparantestapplication.presenter.detail_post.component.ItemListComment

/**
 * Created by Muhammad Zaim Milzam on 06/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@Composable
fun DetailPostScreen(
    resultAllPost: ResultListAllPost,
    navController: NavController,
    viewModel: DetailPostViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArrowBack(navController = navController)
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    DetailPostTopSection(
                        allPost = resultAllPost,
                        onItemClick = {
                            navController.navigate(
                                route = Screen.DetailUserScreen.passtoDetailUserScreen(
                                    userId = resultAllPost.userId.toString()
                                )
                            )
                        })
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Comments :")
                    if (state.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(top = 32.dp),

                            )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                items(state.result) { result ->
                    ItemListComment(comment = result)
                }
            }

        }
    }
}