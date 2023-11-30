package org.sopt.dosopttemplate.presentation.home.doandroid

import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.databinding.FragmentDoAndroidBinding

@AndroidEntryPoint
class DoAndroidFragment : BaseFragment<FragmentDoAndroidBinding>(){
    override val layoutResId: Int
        get() = R.layout.fragment_do_android
}