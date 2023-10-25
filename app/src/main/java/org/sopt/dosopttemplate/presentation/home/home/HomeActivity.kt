package org.sopt.dosopttemplate.presentation.home.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseActivity
import org.sopt.dosopttemplate.databinding.ActivityHomeBinding
import org.sopt.dosopttemplate.presentation.home.mypage.MyPageFragment
import org.sopt.dosopttemplate.presentation.home.doandroid.DoAndroidFragment

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initMakeHomeView()
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
                    replaceFragment(MyPageFragment())
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
}