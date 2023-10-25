package org.sopt.dosopttemplate.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.sopt.dosopttemplate.data.Friend
import org.sopt.dosopttemplate.databinding.ItemHomeFriendOriginalBinding


class HomeFriendAdapter(context: Context) : RecyclerView.Adapter<HomeFriendAdapter.FriendViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }

    private var friendList: List<Friend> = emptyList()

    inner class FriendViewHolder(private val binding: ItemHomeFriendOriginalBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(friendData: Friend) {
            Glide.with(binding.root).load(friendData.profile_img).into(binding.imgItemOriginal)
            binding.tvItemOriginalName.text = friendData.name
            binding.tvItemOriginalMsg.text = friendData.profile_message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val binding = ItemHomeFriendOriginalBinding.inflate(inflater, parent, false)
        return FriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.onBind(friendList[position])
    }

    override fun getItemCount() = friendList.size

    fun setFriendList(friendList: List<Friend>) {
        this.friendList = friendList.toList()
        notifyDataSetChanged()
    }

}