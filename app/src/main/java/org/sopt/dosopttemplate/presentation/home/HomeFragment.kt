package org.sopt.dosopttemplate.presentation.home

import android.os.Bundle
import android.view.View
import org.sopt.dosopttemplate.R
import org.sopt.dosopttemplate.base.BaseFragment
import org.sopt.dosopttemplate.data.Friend
import org.sopt.dosopttemplate.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val friendAdapter = HomeFriendAdapter(requireContext())
        binding.rcvHome.adapter = friendAdapter
        friendAdapter.setFriendList(mockFriendList)
    }

    private val mockFriendList = listOf<Friend>(
        Friend(
            profile_img = R.drawable.main_image,
            name = "아리에띠",
            profile_message = "111"
        ),
        Friend(
            profile_img = R.drawable.main_image,
            name = "아리에띠",
            profile_message = "222"
        ),
        Friend(
            profile_img = R.drawable.main_image,
            name = "아리에띠",
            profile_message = "333"
        ),
    )
}