package org.sopt.dosopttemplate.presentation.home.follower

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.sopt.dosopttemplate.data.entity.FollowerList
import org.sopt.dosopttemplate.databinding.ItemFollowerFollowerListBinding
import org.sopt.dosopttemplate.util.ItemDiffCallback

class FollowerAdapter(context: Context) : ListAdapter<FollowerList.FollowerListData, FollowerViewHolder>(
    ItemDiffCallback<FollowerList.FollowerListData>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )
) {

    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerFollowerListBinding.inflate(inflater, parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }
}