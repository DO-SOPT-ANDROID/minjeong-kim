package org.sopt.dosopttemplate.util

import android.content.Context
import android.widget.Toast

object Toast {
    private var toast: Toast? = null

    fun makeToast(context: Context, message: String) {
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast!!.show()
    }
}