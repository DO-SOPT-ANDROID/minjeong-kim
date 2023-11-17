package org.sopt.dosopttemplate.presentation.home.follower

import androidx.recyclerview.widget.RecyclerView
import org.sopt.dosopttemplate.data.entity.FollowerList
import org.sopt.dosopttemplate.databinding.ItemFollowerFollowerListBinding
import org.sopt.dosopttemplate.util.loadUrl

class FollowerViewHolder(private val binding: ItemFollowerFollowerListBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: FollowerList.FollowerListData) {
        with(binding) {
            imgItemFollower.loadUrl(data.avatar)
            tvItemFollowerName.text = data.first_name
            tvItemFollowerEmail.text = data.email
        }
    }
}