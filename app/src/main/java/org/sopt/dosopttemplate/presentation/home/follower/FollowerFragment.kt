package org.sopt.dosopttemplate.presentation.home.follower

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.databinding.FragmentFollowerBinding

@AndroidEntryPoint
class FollowerFragment : BaseFragment<FragmentFollowerBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_follower

    private val followerViewModel by viewModels<FollowerViewModel>()
    private lateinit var followerAdapter: FollowerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = followerViewModel

        initMakeAdapter()
    }

    private fun initMakeAdapter() {
        Log.d("follower fragment: ", "test")
        followerAdapter = FollowerAdapter(requireContext())
        binding.rcvFollower.adapter = followerAdapter

        followerViewModel.getFollowerList()

        followerViewModel.followerList.observe(viewLifecycleOwner) {
            followerAdapter.submitList(it)
        }
    }
}