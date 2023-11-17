package org.sopt.dosopttemplate.presentation.home.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_home

    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var friendAdapter: HomeFriendAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = homeViewModel

        initMakeAdapter()

    }

    private fun initMakeAdapter() {
        friendAdapter = HomeFriendAdapter(requireContext())
        binding.rcvHome.adapter = friendAdapter
        homeViewModel.mockProfileList.observe(viewLifecycleOwner) {
            friendAdapter.submitList(it)
        }
    }

    fun scrollToTop() {
        binding.rcvHome.smoothScrollToPosition(POSITION_TOP)
    }

    companion object {
        const val POSITION_TOP = 0
    }

}