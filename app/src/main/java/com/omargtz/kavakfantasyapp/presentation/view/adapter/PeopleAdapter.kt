package com.omargtz.kavakfantasyapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.databinding.ItemPeopleBinding

class PeopleAdapter(): RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    var brastlewark = listOf<PeopleDto>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class PeopleViewHolder (val binding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PeopleDto) {
            binding.people = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PeopleViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPeopleBinding.inflate(layoutInflater, parent, false)
                return PeopleViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PeopleViewHolder.from(parent)

    override fun getItemCount() = brastlewark.size

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val item = brastlewark.get(position)
        holder.bind(item)
    }
}