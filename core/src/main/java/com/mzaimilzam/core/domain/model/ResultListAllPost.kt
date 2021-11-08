package com.mzaimilzam.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Muhammad Zaim Milzam on 05/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
@Parcelize
data class ResultListAllPost(
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null,
    val userId: Int? = null,
    val companyName: String? = null,
    val username: String? = null,
) : Parcelable
