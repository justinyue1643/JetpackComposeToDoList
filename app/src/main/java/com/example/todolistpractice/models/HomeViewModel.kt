package com.example.todolistpractice.models

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.todolistpractice.data.Task

class HomeViewModel: ViewModel() {
    var taskList = mutableStateListOf<Task>()

    fun addTask(t: Task) {
        taskList.add(t)
    }
}