package com.omargtz.kavakfantasyapp.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.omargtz.kavakfantasyapp.R
import com.omargtz.kavakfantasyapp.databinding.FragmentPeopleBinding
import com.omargtz.kavakfantasyapp.databinding.ItemPeopleBinding
import com.omargtz.kavakfantasyapp.presentation.view.adapter.PeopleAdapter
import com.omargtz.kavakfantasyapp.presentation.viewmodel.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleFragment : Fragment() {

    lateinit var binding: FragmentPeopleBinding
    private val viewModel by viewModels<PeopleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeLoadPeopleUseCase()
        viewModel.loadPeople()
    }

    private fun subscribeLoadPeopleUseCase() {
         viewModel.peopleResult.observe(viewLifecycleOwner, Observer {
             Log.i("Result", it.toString())
         })
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PeopleFragment().apply {

            }
    }
}