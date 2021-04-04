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
import com.omargtz.kavakfantasyapp.presentation.viewmodel.PeopleViewModel


class PeopleFragment : Fragment() {

    val viewModel by viewModels<PeopleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeLoadPeopleUseCase()
        viewModel.loadPeople()
    }

    fun subscribeLoadPeopleUseCase() {
         viewModel.peopleResult.observe(viewLifecycleOwner, Observer {
             Log.i("Resul", it.toString())
         })
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PeopleFragment().apply {

            }
    }
}