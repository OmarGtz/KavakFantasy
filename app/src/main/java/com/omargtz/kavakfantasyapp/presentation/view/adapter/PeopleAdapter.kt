package com.omargtz.kavakfantasyapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.databinding.ItemPeopleBinding
import com.omargtz.kavakfantasyapp.presentation.view.PeopleFragmentDirections
import com.omargtz.kavakfantasyapp.utils.toJson

class PeopleAdapter: ListAdapter< PeopleDto,PeopleAdapter.PeopleViewHolder>(PeopleDiffCallback) {

    class PeopleViewHolder (val binding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PeopleDto) {
            binding.people = item
            ViewCompat.setTransitionName(binding.image, "image_${item.name}")
            ViewCompat.setTransitionName(binding.name, "name_${item.name}")
            ViewCompat.setTransitionName(binding.age, "age_${item.name}")
            ViewCompat.setTransitionName(binding.hairColor, "hairColor_${item.name}")
            binding.root.setOnClickListener {
                onItemClicked(item, binding)
            }
            binding.executePendingBindings()
        }

        fun onItemClicked(item: PeopleDto, binding: ItemPeopleBinding) {
            val directions = PeopleFragmentDirections.actionPeopleScreenToDetailScreen(item.toJson())
            val extras = FragmentNavigatorExtras(
                binding.image to "image_${item.name}",
                binding.name to "name_${item.name}",
                binding.age to "age_${item.name}",
                binding.hairColor to "hairColor_${item.name}")
            binding.root.findNavController().navigate(
                directions,
                extras
            )
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