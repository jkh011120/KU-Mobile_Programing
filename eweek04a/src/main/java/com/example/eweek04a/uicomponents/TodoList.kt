package com.example.eweek04a.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoItemFactory
import com.example.eweek04a.model.TodoStatus

@Composable
fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var checked by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {
        //on_off check
        TodoSwitch(checked = checked, onCheckedChange = { checked = it })

        if (checked == false) {
            //todoList 찍기
            todoList.forEachIndexed { index, item ->
                Card(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    Row {
                        TodoCheckbox(checked = item.status == TodoStatus.COMPLETED) { isChecked ->
                            todoList[index] = item.copy(
                                status = if (isChecked) TodoStatus.COMPLETED
                                else TodoStatus.PENDING
                            )
                        }
                        TodoItem(item = item)
                    }
                }
            }
        } else {
            todoList.forEachIndexed { index, item ->
                if (item.status == TodoStatus.PENDING) {
                    Card(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                    ) {

                        Row {
                            TodoCheckbox(checked = item.status == TodoStatus.COMPLETED) { isChecked ->
                                todoList[index] = item.copy(
                                    status = if (isChecked) TodoStatus.COMPLETED
                                    else TodoStatus.PENDING
                                )
                            }
                            TodoItem(item = item)
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList())
}