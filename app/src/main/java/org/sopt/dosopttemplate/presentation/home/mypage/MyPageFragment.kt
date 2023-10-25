package org.sopt.dosopttemplate.presentation.home.mypage

import android.os.Bundle
import android.view.View
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.databinding.FragmentMypageBinding

class MyPageFragment : BaseFragment<FragmentMypageBinding>(R.layout.fragment_mypage) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMakeMainView()
    }

    private fun initMakeMainView() {
        with(binding) {
            tvMainNickName.text = arguments?.getString("nickName")
            tvMainID.text = arguments?.getString("id")
            tvMainMBTI.text = arguments?.getString("mbti")
        }
    }

}