package org.sopt.dosopttemplate.presentation.home.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.data.datasource.local.SharedPreference
import org.sopt.dosopttemplate.databinding.FragmentMypageBinding
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity

class MyPageFragment : BaseFragment<FragmentMypageBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_mypage

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMakeMainView()
        initSetLogOut()
    }

    private fun initMakeMainView() {
        with(binding) {
            tvMainNickName.text = arguments?.getString("nickName")
            tvMainID.text = arguments?.getString("id")
            tvMainMBTI.text = arguments?.getString("mbti")
        }
    }

    private fun initSetLogOut() {
        binding.tvMainLogOut.setOnClickListener {
            SharedPreference.clearUserData()
            activity?.let {
                val intent = Intent(context, LogInActivity::class.java)
                startActivity(intent)
            }

        }
    }

}