package com.omargtz.kavakfantasyapp.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omargtz.kavakfantasyapp.base.KavakResult
import com.omargtz.kavakfantasyapp.data.model.Brastlewark
import com.omargtz.kavakfantasyapp.domain.usecase.LoadPeopleUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PeopleViewModel @ViewModelInject constructor(private val loadPeopleUseCase: LoadPeopleUseCase): ViewModel() {

    private val _peopleResult: MutableLiveData<KavakResult<Brastlewark>> = MutableLiveData()
    val peopleResult: LiveData<KavakResult<Brastlewark>> = _peopleResult

    fun loadPeople() {
        viewModelScope.launch {
            loadPeopleUseCase.invoke(Unit).collect {
                _peopleResult.value = it
            }
        }
    }
}