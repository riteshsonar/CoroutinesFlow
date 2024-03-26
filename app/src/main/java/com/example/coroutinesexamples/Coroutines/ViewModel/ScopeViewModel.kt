package com.example.coroutinesexamples.Coroutines.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScopeViewModel : ViewModel() {
    private val mutableLiveData = MutableLiveData<String>()
    val liveData: LiveData<String> get() = mutableLiveData

    fun getString() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            val result = repositoryFunction()
            withContext(Main){
                mutableLiveData.value= result!!
            }
        }
    }

    private suspend fun repositoryFunction(): String? {
        return "Hello"
    }
}