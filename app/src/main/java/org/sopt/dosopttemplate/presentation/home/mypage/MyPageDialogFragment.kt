package org.sopt.dosopttemplate.presentation.home.mypage

import android.content.Intent
import android.os.Bundle
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseDialogFragment
import org.sopt.dosopttemplate.data.datasource.local.SharedPreference
import org.sopt.dosopttemplate.databinding.FragmentMypageDialogBinding
import org.sopt.dosopttemplate.presentation.logIn.LogInActivity

@AndroidEntryPoint
class MyPageDialogFragment : BaseDialogFragment<FragmentMypageDialogBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_mypage_dialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initMakeDialogCancelable()
        initSetCancelBtn()
        initSetConfirmBtn()
    }

    private fun initMakeDialogCancelable() {
        dialog?.setCancelable(true)
        dialog?.setCanceledOnTouchOutside(true)
    }

    private fun initSetCancelBtn() {
        binding.tvDialogCancel.setOnClickListener {
            dismiss()
        }
    }

    private fun initSetConfirmBtn() {
        binding.tvDialogConfirm.setOnClickListener {
            setLogOut()
        }
    }

    private fun setLogOut() {
        SharedPreference.clearUserData()
        activity?.let {
            val intent = Intent(context, LogInActivity::class.java)
            startActivity(intent)
        }
    }
}

