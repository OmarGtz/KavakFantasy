package com.omargtz.kavakfantasyapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omargtz.kavakfantasyapp.R
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.databinding.ItemPeopleBinding
import com.omargtz.kavakfantasyapp.presentation.view.ARG_PEOPLE_DETAIL
import com.omargtz.kavakfantasyapp.utils.toJson

class PeopleAdapter: ListAdapter< PeopleDto,PeopleAdapter.PeopleViewHolder>(PeopleDiffCallback) {

    class PeopleViewHolder (val binding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PeopleDto) {
            binding.people = item
            binding.root.setOnClickListener {
                val bundle = bundleOf(ARG_PEOPLE_DETAIL to item.toJson())
                binding.root.findNavController().navigate(
                    R.id.action_peopleScreen_to_detailScreen,
                    bundle
                )
            }
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

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

object PeopleDiffCallback : DiffUtil.ItemCallback<PeopleDto>() {
    override fun areItemsTheSame(oldItem: PeopleDto, newItem: PeopleDto) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: PeopleDto, newItem: PeopleDto) = oldItem == newItem
}