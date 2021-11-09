package com.mzaimilzam.kumparantestapplication.presenter.detail_user.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mzaimilzam.core.domain.model.Users

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

@Composable
fun ItemDetailUser(
    user: Users
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Name : ${user.name.toString()}",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
        )
        Text(
            text = "Email : ${user.email.toString()}",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
        )
        Text(
            text = "Address : ${user.address.toString()}",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
        )
        Text(
            text = "Company : ${user.companyName.toString()}",
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
        )
    }
}