package org.sopt.dosopttemplate.presentation.home.follower

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.databinding.FragmentFollowerBinding
import org.sopt.dosopttemplate.util.UiState

@AndroidEntryPoint
class FollowerFragment : BaseFragment<FragmentFollowerBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_follower

    private val followerViewModel by viewModels<FollowerViewModel>()
    private var _followerAdapter: FollowerAdapter? = null
    private val followerAdapter
        get() = requireNotNull(_followerAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = followerViewModel

        initMakeAdapter()
    }

    private fun initMakeAdapter() {
        _followerAdapter = FollowerAdapter(requireContext())
        binding.rcvFollower.adapter = followerAdapter

        followerViewModel.getFollowerList()

        followerViewModel.followerList.flowWithLifecycle(lifecycle).onEach { uiState ->
            when (uiState) {
                is UiState.Success -> {
                    followerAdapter.submitList(uiState.data)
                }

                else -> {}
            }
        }.launchIn(lifecycleScope)
    }
}