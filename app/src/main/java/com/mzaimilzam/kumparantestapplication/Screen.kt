package com.mzaimilzam.kumparantestapplication

/**
 * Created by Muhammad Zaim Milzam on 04/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

const val DETAIL_SCREEN_USERNAME = "username"
const val DETAIL_SCREEN_TITLE = "tittle"
const val DETAIL_SCREEN_BODY = "body"
const val DETAIL_SCREEN_POSTID = "postId"
const val DETAIL_SCREEN_USERID = "userId"

const val DETAIL_USER_SCREEN_USERID = "userId"

const val DETAIL_PHOTO_SCREEN_URL = "url"
const val DETAIL_PHOTO_SCREEN_TITLE = "titlePhoto"

const val DETAIL_PHOTO_SCREEN_PHOTO = "photo"

sealed class Screen(val route: String) {
    object AllPostScreen : Screen("all_post_screen")
    object DetailPostScreen :
        Screen("detail_post_screen/{$DETAIL_SCREEN_USERNAME}/{$DETAIL_SCREEN_TITLE}/{$DETAIL_SCREEN_BODY}/{$DETAIL_SCREEN_POSTID}/{$DETAIL_SCREEN_USERID}")

    fun passtoDetailScreen(
        username: String,
        title: String,
        body: String,
        postId: String,
        userId: String
    ): String {
        return "detail_post_screen/$username/$title/$body/$postId/$userId"
    }

    object DetailUserScreen : Screen("detail_user_screen/{$DETAIL_USER_SCREEN_USERID}")

    fun passtoDetailUserScreen(
        userId: String
    ): String {
        return "detail_user_screen/$userId"
    }

    object DetailPhotoScreen : Screen("detail_photo_screen")
//    object DetailPhotoScreen :
//        Screen("detail_photo_screen/{$DETAIL_PHOTO_SCREEN_URL}/{$DETAIL_PHOTO_SCREEN_TITLE}")
//
//    fun passtoDetailPhotoScreen(
//        url: String,
//        title: String
//    ): String {
//        return "detail_photo_screen/$url/$title"
//    }

}