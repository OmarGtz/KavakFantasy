package com.omargtz.kavakfantasyapp.presentation.view

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.model.PeopleDto
import com.omargtz.kavakfantasyapp.databinding.FragmentPeopleBinding
import com.omargtz.kavakfantasyapp.presentation.view.adapter.PeopleAdapter
import com.omargtz.kavakfantasyapp.presentation.viewmodel.PeopleViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PeopleFragment : Fragment() {

    lateinit var binding: FragmentPeopleBinding
    private val viewModel by viewModels<PeopleViewModel>()

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

    private fun setupPeopleOfBrastlewark(people: List<PeopleDto>) {
        with(binding) {
            val adapter = PeopleAdapter()
            adapter.brastlewark = people
            peopleOfBrastlewark.layoutManager = LinearLayoutManager(requireContext())
            peopleOfBrastlewark.adapter = adapter
        }
    }

    private fun subscribeLoadPeopleUseCase() {
         viewModel.peopleResult.observe(viewLifecycleOwner, Observer {
             when (it) {
                 is KavakResult.Loading -> Log.i("Loading", "Loading")
                 is KavakResult.Success -> setupPeopleOfBrastlewark(it.data.Brastlewark)
                 is KavakResult.Error -> {
                     LoadBrastlewarkPeopleErrorFragment().show(childFragmentManager, "error")
                 }
             }
         })
    }

    class LoadBrastlewarkPeopleErrorFragment : DialogFragment() {
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            return MaterialAlertDialogBuilder(requireContext())
                .setMessage("Lo sentimos Ocurrio un error inesperado. Reintenta de nuevo porfavor")
                .setPositiveButton("Reintentar") { _, _ ->
                    dismiss()
                }
                .create()
        }
    }


}