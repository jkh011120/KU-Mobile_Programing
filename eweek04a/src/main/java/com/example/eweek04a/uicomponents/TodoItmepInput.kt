package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.eweek04a.TodoService
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory

@Composable
fun TodoItemInput(todoList: MutableList<Item>, modifier: Modifier = Modifier) {

    var textFieldState by remember { mutableStateOf("") }

    Row(
        verticalAlignment = Alignment.Bottom
    ) {

        TextField(
            value = textFieldState, // 우리가 입력하는 내용이 textFieldState에 저장됨.
            onValueChange = { text: String -> textFieldState = text },
            placeholder = { Text("할 일을 입력을 하세요.") }
        )

        Button(onClick = {
            TodoService(todoList).addContent(textFieldState)
        }) { Text("추가") }

    }

}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())
}