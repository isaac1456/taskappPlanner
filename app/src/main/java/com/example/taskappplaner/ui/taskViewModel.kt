package com.example.taskappplaner.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskappplaner.dependencies.taskRep
import com.example.taskappplaner.model.modelTask
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.invoke
import kotlinx.coroutines.launch

class taskViewModel(val taskRepo: taskRep) : ViewModel() {

    private val listTask: MutableLiveData<List<modelTask>> by lazy {
        MutableLiveData<List<modelTask>>().also {

        }

    }

    fun getAllTask(): LiveData<List<modelTask>> {
        return listTask
    }


    init {
        createTask(modelTask(0, "TaskPlanner", "Terminar el poryecto"))
        createTask(modelTask(0, "TaskPlanner1", "Terminar el poryecto"))
        createTask(modelTask(0, "TaskPlanner2", "Terminar el poryecto"))
        createTask(modelTask(0, "TaskPlanner3", "Terminar el poryecto"))

    }

    @ExperimentalCoroutinesApi
    fun createTask(modelTask: modelTask) {
        viewModelScope.launch {
            Dispatchers.IO {
                taskRepo.taskD.create(modelTask)
            }
        }
    }

}