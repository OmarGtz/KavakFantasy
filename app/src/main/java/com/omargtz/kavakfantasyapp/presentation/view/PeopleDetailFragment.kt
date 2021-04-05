package com.omargtz.kavakfantasyapp.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.omargtz.kavakfantasyapp.R
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.databinding.FragmentPeopleDetailBinding
import com.omargtz.kavakfantasyapp.utils.fromJson


class PeopleDetailFragment : Fragment() {

    private var peopleDetail: PeopleDto? = null
    private lateinit var binding: FragmentPeopleDetailBinding
    private val detailFragmentArgs: PeopleDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        peopleDetail = detailFragmentArgs.detail.fromJson(PeopleDto::class.java, detailFragmentArgs.detail)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTransitionName(binding.image, "image_${peopleDetail?.name}")
        ViewCompat.setTransitionName(binding.cardPeople.name, "name_${peopleDetail?.name}")
        ViewCompat.setTransitionName(binding.cardPeople.age, "age_${peopleDetail?.name}")
        ViewCompat.setTransitionName(binding.cardPeople.hairColor, "hairColor_${peopleDetail?.name}")
        with(binding) {
            people = peopleDetail
            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }
        }
    }
}