package com.mzaimilzam.kumparantestapplication.presenter.detail_post.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mzaimilzam.core.domain.model.ResultListAllPost
import timber.log.Timber

/**
 * Created by Muhammad Zaim Milzam on 05/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@Composable
fun DetailPostTopSection(
    allPost: ResultListAllPost,
    onItemClick: (ResultListAllPost) -> Unit,

    ) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
    ) {
        Timber.d("DetailpostTopSection : ${allPost.userId}")
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = allPost.title.toString()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = allPost.body.toString()
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
                style = MaterialTheme.typography.body2,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Username : ${allPost.username.toString()}",
                style = MaterialTheme.typography.caption,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable { onItemClick(allPost) }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
        }
    }

}
