package org.sopt.dosopttemplate.presentation.home.home


import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.data.entity.UserData
import org.sopt.dosopttemplate.databinding.ActivityHomeBinding
import org.sopt.dosopttemplate.presentation.home.doandroid.DoAndroidFragment
import org.sopt.dosopttemplate.presentation.home.mypage.MyPageFragment
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity
import org.sopt.dosopttemplate.util.SnackBar.makeSnackBar
import org.sopt.dosopttemplate.util.getParcelable

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private var backPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMakeHomeView()
        initFinishApp()
    }

    private fun initFinishApp() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (System.currentTimeMillis() - backPressedTime >= 2000L) {
                    backPressedTime = System.currentTimeMillis()
                    makeSnackBar(binding.root, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.")
                } else {
                    finishAffinity()
                }
            }
        }
        )
    }

    private fun initMakeHomeView() {
        initMakeFragment()
        clickBottomNavigation()
    }

    private fun initMakeFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if (currentFragment == null ) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home, HomeFragment())
                .commit()
        }
        binding.bnvHome.selectedItemId = R.id.menu_home
    }

    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.menu_home-> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.menu_do_android-> {
                    replaceFragment(DoAndroidFragment())
                    true
                }

                R.id.menu_myPage-> {
                    makeMyPageView()
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, fragment)
            .commit()
    }

    private fun makeMyPageView() {
        val myPageFragment = MyPageFragment()
        val userData = intent.getParcelable(LogInActivity.USER_DATA, UserData::class.java)

        myPageFragment.arguments = Bundle().apply {
            putString("nickName", userData?.nickName ?: "")
            putString("id", userData?.id ?: "")
            putString("mbti", userData?.mbti ?: "")
        }
        replaceFragment(myPageFragment)
    }
}