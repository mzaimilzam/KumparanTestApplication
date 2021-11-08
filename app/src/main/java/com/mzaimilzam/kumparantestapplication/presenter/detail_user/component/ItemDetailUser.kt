package com.mzaimilzam.kumparantestapplication.presenter.detail_user.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
        )
        Text(
            text = "Email : ${user.email.toString()}",
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
        )
        Text(
            text = "Address : ${user.address.toString()}",
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
        )
        Text(
            text = "Company : ${user.companyName.toString()}",
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
        )
    }
}