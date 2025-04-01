package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        //mutableStateListOf<Item>() 빈 item 생성
        TodoItemFactory.makeTodoList()
    }
    Box(Modifier.fillMaxSize()) {
        Column {
            TodoListTitle()
            TodoList(todoList)
        }
        Box(
            Modifier.align(Alignment.BottomCenter)
        ) {
            TodoItemInput(todoList)
        }
    }

}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}