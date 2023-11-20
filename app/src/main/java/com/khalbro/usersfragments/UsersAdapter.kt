package com.khalbro.usersfragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.khalbro.usersfragments.databinding.ItemUserBinding

class UsersAdapter(private val listener: (User) -> Unit) :
    ListAdapter<User, UsersViewHolder>(UserDiffCallBAck()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder.from(parent).apply {
            binding.root.setOnClickListener {
                val position = adapterPosition
                val user = getItem(position)
                    listener(user)
            }
        }
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        getItem(position)?.let { user ->
            holder.bind(user)
        }
    }
}

class UsersViewHolder( val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: User) {
        binding.ivIconUser.setImageResource(item.iconUser)
        binding.tvName.text = item.nameUser
        binding.etSurnameContact.text = item.surname
        binding.tvPhoneNumber.text = item.phoneNumberUser
    }

    companion object {
        fun from(parent: ViewGroup): UsersViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemUserBinding.inflate(layoutInflater, parent, false)
            return UsersViewHolder(binding)
        }
    }
}

class UserDiffCallBAck : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
