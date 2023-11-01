package org.sopt.dosopttemplate.presentation.home.home

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.entity.Profile
import org.sopt.dosopttemplate.databinding.ItemHomeFriendMusicBinding
import org.sopt.dosopttemplate.databinding.ItemHomeFriendOriginalBirthdayBinding
import org.sopt.dosopttemplate.databinding.ItemHomeMyProfileBinding
import org.sopt.dosopttemplate.util.loadUrl

sealed class HomeViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    class MyProfileViewHolder(private val binding: ItemHomeMyProfileBinding) :
        HomeViewHolder(binding) {

        fun onBind(data: Profile.MyProfile) {
            with(binding) {
                item = data
                imgItemMyProfile.loadUrl(data.profile_img)
                tvItemMyName.text = data.name
                tvItemMyMsg.text = data.profile_message
            }
        }
    }

    class FriendViewHolder(private val binding: ItemHomeFriendOriginalBirthdayBinding) :
        HomeViewHolder(binding) {

        fun onBind(data: Profile.FriendBirthday) {
            with(binding) {
                imgItemOriginal.loadUrl(data.profile_img)
                tvItemOriginalName.text = data.name
                tvItemOriginalMsg.text = data.profile_message
                tvItemOrigianlBirthday.text = data.birthday
            }
        }
    }

    class FriendMusicViewHolder(private val binding: ItemHomeFriendMusicBinding) :
        HomeViewHolder(binding) {

        fun onBind(data: Profile.FriendIncludeMusic) {
            with(binding) {
                item = data
                imgItemMusic.loadUrl(data.profile_img)
                tvItemFriendMusicName.text = data.name
                tvItemFriendMusicMsg.text = data.profile_message
                tvItemFriendMusic.text = data.music
            }
        }
    }
}
