package org.sopt.dosopttemplate.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

object SnackBar {
    private var snackBar : Snackbar? = null

    fun makeSnackBar(view: View, message: String) {
        snackBar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        snackBar!!.show()
    }
}