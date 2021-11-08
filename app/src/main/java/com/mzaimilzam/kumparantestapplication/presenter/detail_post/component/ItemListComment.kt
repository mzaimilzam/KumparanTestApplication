package com.mzaimilzam.kumparantestapplication.presenter.detail_post.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mzaimilzam.core.domain.model.Comment

/**
 * Created by Muhammad Zaim Milzam on 06/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@Composable
fun ItemListComment(
    comment: Comment,
    ) {
    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = comment.body.toString()
                .replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() },
            style = MaterialTheme.typography.body2,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Author : ${comment.name.toString()}",
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {}
        )
        Spacer(modifier = Modifier.height(4.dp))
        Divider()
        Spacer(modifier = Modifier.height(4.dp))

    }

}