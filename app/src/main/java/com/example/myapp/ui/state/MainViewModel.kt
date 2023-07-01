package com.example.myapp.ui.state

import androidx.lifecycle.Lifecycle.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val state: LiveData<State> get() = stateData
    val stateData = MutableLiveData<State>()


    fun increment () {

    }
}