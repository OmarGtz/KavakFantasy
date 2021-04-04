package com.omargtz.kavakfantasyapp.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omargtz.kavakfantasyapp.R
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.databinding.FragmentPeopleDetailBinding
import com.omargtz.kavakfantasyapp.utils.fromJson

const val ARG_PEOPLE_DETAIL = "detail"

class PeopleDetailFragment : Fragment() {

    private var peopleDetail: PeopleDto? = null
    private lateinit var binding: FragmentPeopleDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            peopleDetail = bundle.getString(ARG_PEOPLE_DETAIL)?.let {
                it.fromJson(PeopleDto::class.java, it)
            }
        }
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
        with(binding) {
            people = peopleDetail
        }
    }

    companion object {
         @JvmStatic
        fun newInstance(people: String) =
            PeopleDetailFragment().apply {
                arguments = Bundle().apply {
                   putString(ARG_PEOPLE_DETAIL, people)
                }
            }
    }
}