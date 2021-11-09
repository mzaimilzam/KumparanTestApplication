package com.mzaimilzam.kumparantestapplication.presenter

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.mzaimilzam.core.domain.model.ResultAlbumList
import com.mzaimilzam.core.domain.model.ResultListAllPost
import com.mzaimilzam.kumparantestapplication.*
import com.mzaimilzam.kumparantestapplication.presenter.all_post.AllPostListScreen
import com.mzaimilzam.kumparantestapplication.presenter.detail_photo.DetailPhotoScreen
import com.mzaimilzam.kumparantestapplication.presenter.detail_post.DetailPostScreen
import com.mzaimilzam.kumparantestapplication.presenter.detail_user.DetailUserScreen
import com.mzaimilzam.kumparantestapplication.ui.theme.KumparanTestApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KumparanTestApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.AllPostScreen.route
                    )
                    {
                        composable(
                            route = Screen.AllPostScreen.route
                        ) {
                            AllPostListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.DetailPostScreen.route,
                            arguments = listOf(
                                navArgument(DETAIL_SCREEN_USERNAME) {
                                    type = NavType.StringType
                                },
                                navArgument(DETAIL_SCREEN_TITLE) {
                                    type = NavType.StringType
                                },
                                navArgument(DETAIL_SCREEN_BODY) {
                                    type = NavType.StringType
                                },
                                navArgument(DETAIL_SCREEN_POSTID) {
                                    type = NavType.StringType
                                },
                                navArgument(DETAIL_SCREEN_USERID) {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            val username = remember {
                                it.arguments?.getString(DETAIL_SCREEN_USERNAME)
                            }
                            val title = remember {
                                it.arguments?.getString(DETAIL_SCREEN_TITLE)
                            }
                            val body = remember {
                                it.arguments?.getString(DETAIL_SCREEN_BODY)
                            }
                            val postId = remember {
                                it.arguments?.getString(DETAIL_SCREEN_POSTID)
                            }
                            val userId = remember {
                                it.arguments?.getString(DETAIL_SCREEN_USERID)
                            }
                            val allPost = ResultListAllPost(
                                id = postId?.toInt(),
                                title = title,
                                body = body,
                                username = username,
                                userId = userId?.toInt()
                            )
                            DetailPostScreen(allPost, navController)
                        }
                        composable(
                            route = Screen.DetailUserScreen.route,
                            arguments = listOf(
                                navArgument(DETAIL_USER_SCREEN_USERID) {
                                    type = NavType.StringType
                                }
                            )
                        ) {

                            DetailUserScreen(navController = navController)
                        }
                        composable(route = Screen.DetailPhotoScreen.route) {
                            val result =
                                navController.previousBackStackEntry?.arguments?.getParcelable<ResultAlbumList>(
                                    DETAIL_PHOTO_SCREEN_PHOTO
                                )
                            result?.let {
                                DetailPhotoScreen(
                                    navController = navController,
                                    result = result
                                )

                            }
                        }
                    }

                }
            }
        }
    }
}
