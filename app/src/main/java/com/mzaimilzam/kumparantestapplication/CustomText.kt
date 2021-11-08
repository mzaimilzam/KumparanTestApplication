package com.mzaimilzam.kumparantestapplication

/**
 * Created by Muhammad Zaim Milzam on 06/11/2021.
 * linkedin : Muhammad Zaim Milzam
 */
object CustomText {

    fun toCapitalize(string: String): String {
        return string.replaceFirstChar { text ->
            if (text.equals(text.lowercase())) text.titlecase() else text.toString()
        }
    }
}