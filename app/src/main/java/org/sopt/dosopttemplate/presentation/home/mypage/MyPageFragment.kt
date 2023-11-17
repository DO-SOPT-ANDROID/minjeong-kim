package org.sopt.dosopttemplate.presentation.home.mypage

import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.databinding.FragmentMypageBinding

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMypageBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_mypage

    private var dialogFragment: MyPageDialogFragment = MyPageDialogFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMakeMainView()
        initSetLogOutDialog()
    }

    private fun initMakeMainView() {
        with(binding) {
            tvMainNickName.text = arguments?.getString("nickName")
            tvMainID.text = arguments?.getString("id")
            tvMainMBTI.text = arguments?.getString("mbti")
        }
    }

    private fun initSetLogOutDialog() {
        binding.btnMainLogOut.setOnClickListener {
            dialogFragment.show(childFragmentManager, DIALOG_TAG)
        }
    }

    companion object{
        const val DIALOG_TAG = "dialog"
    }

}