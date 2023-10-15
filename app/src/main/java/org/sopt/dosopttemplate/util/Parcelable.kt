@file:Suppress("DEPRECATION")

package org.sopt.dosopttemplate.util

import android.content.Intent
import android.os.Build

inline fun  <reified T> Intent.getParcelable(key: String, clazz: Class<T>): T? {
   return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) getParcelableExtra(key, clazz)
   else getParcelableExtra(key)
}