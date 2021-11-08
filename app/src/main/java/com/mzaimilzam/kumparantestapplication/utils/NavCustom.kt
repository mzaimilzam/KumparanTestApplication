package com.mzaimilzam.kumparantestapplication.utils

import android.os.Bundle
import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController

/**
 * Created by Muhammad Zaim Milzam on 08/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */

fun NavController.navigate(route: String, vararg args: Pair<String, Parcelable>) {
    navigate(route)

    requireNotNull(currentBackStackEntry?.arguments).apply {
        args.forEach { (key: String, arg: Parcelable) ->
            putParcelable(key, arg)
        }
    }
}

inline fun <reified T : Parcelable> NavBackStackEntry.requiredArg(key: String): T {
    return requireNotNull(arguments) { "arguments bundle is null" }.run {
        requireNotNull(getParcelable(key)) { "argument for $key is null" }
    }
}

fun NavBackStackEntry.requiredArguments(): Bundle = arguments ?: throw IllegalStateException("Arguments were expected, but none were provided!")

@Composable
inline fun <reified T : Parcelable> NavBackStackEntry.rememberRequiredArgument(
    key: String = T::class.qualifiedName!!,
): T = remember {
    requiredArguments().getParcelable<T>(key) ?: throw IllegalStateException("Expected argument with key: $key of type: ${T::class.qualifiedName!!}")
}

@Composable
inline fun <reified T : Parcelable> NavBackStackEntry.rememberArgument(
    key: String = T::class.qualifiedName!!,
): T? = remember {
    arguments?.getParcelable(key)
}
