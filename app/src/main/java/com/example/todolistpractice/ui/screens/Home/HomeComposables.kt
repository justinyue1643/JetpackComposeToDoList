package com.example.todolistpractice.ui.screens.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.todolistpractice.data.Task

@Preview
@Composable
fun PreviewSearchField() {
    SearchField(name = "", {}, {})
}

@Composable
fun SearchField(name: String, onQueryChange: (value: String) -> Unit, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        TextField(name, onQueryChange)
        Button(onClick = onClick) {
            Text("Add")
        }
    }

}

@Preview
@Composable
fun PreviewTaskCard() {
    TaskCard(Task("Jogging"), {})
}

@Composable
fun TaskCard(t: Task, onClick: () -> Unit) {
    Card(
        backgroundColor = Color.Yellow
    ) {
        Box(modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = onClick)
        ) {
            Text(t.name)
        }
    }
}

@Composable
fun ListOfTasks(taskList: List<Task>, navHostController: NavHostController) {
    LazyColumn() {
        items(taskList.size) { index ->
            TaskCard(taskList[index], onClick = {navHostController.navigate("TaskScreen")})
        }
    }
}