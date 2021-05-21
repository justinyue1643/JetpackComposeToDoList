package com.example.todolistpractice.ui.screens.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.todolistpractice.data.Task
import com.example.todolistpractice.models.HomeViewModel
import kotlin.random.Random

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
        SearchField(
            query,
            {value -> query = value},
            onClick = {
                homeViewModel.addTask(Task(Random.nextInt(100), query))
            })
        Spacer(modifier = Modifier.height(16.dp))
        ListOfTasks(homeViewModel.taskList, navHostController)
    }
}