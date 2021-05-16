package com.example.todolistpractice.ui.screens.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.todolistpractice.data.Task
import com.example.todolistpractice.models.HomeViewModel

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(NavHostController(LocalContext.current))
}

@Composable
fun HomeScreen(navHostController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    var query by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchField(query, {value -> query = value}, onClick = {homeViewModel.addTask(Task(query))})
        ListOfTasks(homeViewModel.taskList, navHostController)
    }
}