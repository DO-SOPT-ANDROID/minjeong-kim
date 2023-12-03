package org.sopt.dosopttemplate.base

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.sopt.dosopttemplate.util.SnackBar

abstract class BaseActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int,
) : AppCompatActivity() {
    lateinit var binding: T

    private var backPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.lifecycleOwner = this

        initPressedBackBtn()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        hideKeyboard()
        return super.dispatchTouchEvent(ev)
    }

    private fun hideKeyboard() {
        val currentFocus = currentFocus
        if (currentFocus is EditText) {
            currentFocus.clearFocus()
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0)
        }
    }

    private fun initPressedBackBtn() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() - backPressedTime >= 2000L) {
                    backPressedTime = System.currentTimeMillis()
                    SnackBar.makeSnackBar(binding.root, BACK_MESSAGE)
                } else {
                    finishAffinity()
                }
            }
        }
        )
    }

    companion object {
        const val BACK_MESSAGE = "뒤로가기 버튼을 한번 더 누르면 종료됩니다."
    }
}