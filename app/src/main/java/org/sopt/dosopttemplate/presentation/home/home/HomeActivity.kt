package org.sopt.dosopttemplate.presentation.home.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.data.entity.UserData
import org.sopt.dosopttemplate.databinding.ActivityHomeBinding
import org.sopt.dosopttemplate.presentation.home.doandroid.DoAndroidFragment
import org.sopt.dosopttemplate.presentation.home.follower.FollowerFragment
import org.sopt.dosopttemplate.presentation.home.mypage.MyPageFragment
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity
import org.sopt.dosopttemplate.util.getParcelable

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMakeHomeView()
    }

    private fun initMakeHomeView() {
        initMakeFragment()
        clickBottomNavigation()
        doubleClickBottomNavigation()
    }

    private fun initMakeFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home, HomeFragment())
                .commit()
        }
        binding.bnvHome.selectedItemId = R.id.menu_home
    }

    private fun clickBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    replaceFragment(HomeFragment())
                    true
                }

                R.id.menu_do_android -> {
                    replaceFragment(DoAndroidFragment())
                    true
                }

                R.id.menu_myPage -> {
                    makeMyPageView()
                    true
                }

                R.id.menu_follower -> {
                    replaceFragment(FollowerFragment())
                    true
                }

                else -> false
            }
        }
    }

    private fun doubleClickBottomNavigation() {
        binding.bnvHome.setOnItemReselectedListener {
            supportFragmentManager.findFragmentById(R.id.fcv_home).let { currentFragment ->
                if (currentFragment is HomeFragment) currentFragment.scrollToTop()
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