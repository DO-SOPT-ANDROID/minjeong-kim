package org.sopt.dosopttemplate.presentation.home.home

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.dosopttemplate.data.Profile
import org.sopt.dosopttemplate.databinding.ItemHomeFriendMusicBinding
import org.sopt.dosopttemplate.databinding.ItemHomeFriendOriginalBirthdayBinding
import org.sopt.dosopttemplate.databinding.ItemHomeMyProfileBinding

sealed class HomeViewHolder(binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {

    class MyProfileViewHolder(private val binding: ItemHomeMyProfileBinding) :
        HomeViewHolder(binding) {

        fun onBind(data : Profile.MyProfile) {
            binding.item = data
            Glide.with(binding.root).load(data.profile_img).into(binding.imgItemMyProfile)
            binding.tvItemMyName.text = data.name
            binding.tvItemMyMsg.text = data.profile_message
        }
    }

    class FriendViewHolder(private val binding: ItemHomeFriendOriginalBirthdayBinding) :
        HomeViewHolder(binding) {

        fun onBind(data: Profile.FriendBirthday) {
            Glide.with(binding.root).load(data.profile_img).into(binding.imgItemOriginal)
            binding.tvItemOriginalName.text = data.name
            binding.tvItemOriginalMsg.text = data.profile_message
            binding.tvItemOrigianlBirthday.text = data.birthday
        }
    }

    class FriendMusicViewHolder(private val binding: ItemHomeFriendMusicBinding) :
        HomeViewHolder(binding) {

        fun onBind(data: Profile.FriendIncludeMusic) {
            binding.item = data
            Glide.with(binding.root).load(data.profile_img).into(binding.imgItemMusic)
            binding.tvItemFriendMusicName.text = data.name
            binding.tvItemFriendMusicMsg.text = data.profile_message
            binding.tvItemFriendMusic.text = data.music
        }
    }
}
