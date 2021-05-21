package com.example.todolistpractice.models

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistpractice.data.Task
import com.example.todolistpractice.network.DynamoApi
import com.example.todolistpractice.network.DynamoApiService
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    var taskList = mutableStateListOf<Task>()

    fun addTask(t: Task) {
        taskList.add(t)
        Log.i("HomeViewModel", t.toString())

        viewModelScope.launch {
            try {
                DynamoApi.retrofitService.addTask(t)
            } catch(e: Exception) {
                Log.d("HomeViewModel", e.toString())
            }

        }
    }
}