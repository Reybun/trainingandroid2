package com.example.controle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.controle.databinding.AdapterUserBinding


class UserAdapter(val callBack: IUserAdapterCallBack) : ListAdapter<User, UserAdapterViewHolder>(diffCallBack) {


    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): UserAdapterViewHolder {
        val layoutInflater =
            LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<AdapterUserBinding>(
            layoutInflater,
            R.layout.adapter_user,
            null,
            false
        )
        return UserAdapterViewHolder(binding)
    }


    override fun onBindViewHolder(holder:UserAdapterViewHolder, position: Int) {
        //holder.binding.user = listUser.get(position)
        holder.binding.callback = callBack
        holder.binding.user = getItem(position)
    }


    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem.name == newItem.name || oldItem.weight == newItem.weight
            }

        }

    }


}