package org.sopt.dosopttemplate.presentation.home.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.dosopttemplate.data.entity.Profile
import org.sopt.dosopttemplate.databinding.ItemHomeFriendMusicBinding
import org.sopt.dosopttemplate.databinding.ItemHomeFriendOriginalBirthdayBinding
import org.sopt.dosopttemplate.databinding.ItemHomeMyProfileBinding
import org.sopt.dosopttemplate.util.ItemDiffCallback


class HomeFriendAdapter(context: Context) : ListAdapter<Profile, HomeViewHolder>(
    ItemDiffCallback<Profile>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    private val inflater by lazy { LayoutInflater.from(context) }

    override fun getItemViewType(position: Int) = when (currentList[position]) {
        is Profile.MyProfile -> MY_PROFILE
        is Profile.FriendBirthday -> FRIEND_ORIGINAL
        is Profile.FriendIncludeMusic -> FRIEND_INCLUDE_MUSIC
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {


        return when (viewType) {
            MY_PROFILE -> {
                val binding = ItemHomeMyProfileBinding.inflate(inflater, parent, false)
                HomeViewHolder.MyProfileViewHolder(binding)
            }

            FRIEND_ORIGINAL -> {
                val binding = ItemHomeFriendOriginalBirthdayBinding.inflate(inflater, parent, false)
                HomeViewHolder.FriendViewHolder(binding)
            }

            else -> {
                val binding = ItemHomeFriendMusicBinding.inflate(inflater, parent, false)
                HomeViewHolder.FriendMusicViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val item = currentList[position]

        when (holder) {
            is HomeViewHolder.MyProfileViewHolder -> holder.onBind(item as Profile.MyProfile)
            is HomeViewHolder.FriendViewHolder -> holder.onBind(item as Profile.FriendBirthday)
            is HomeViewHolder.FriendMusicViewHolder -> holder.onBind(item as Profile.FriendIncludeMusic)
        }
    }

    companion object {
        const val MY_PROFILE = 0
        const val FRIEND_ORIGINAL = 1
        const val FRIEND_INCLUDE_MUSIC = 2
    }

}