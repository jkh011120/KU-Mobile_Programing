package com.example.eweek04a

import com.example.eweek04a.model.Item
import com.example.eweek04a.model.TodoStatus
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TodoService(val todoList: MutableList<Item>) {
    //1. 메모 추가.
    fun addContent(content: String) {
        val currentTime = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
        todoList.add(Item(content, currentTime))
    }

    //2.완료 체크
    fun checkContent(idx: Int) {
        todoList[idx].status = TodoStatus.COMPLETED
        println("메모 완료 처리됨: ${todoList[idx].toString()}")
    }

    //3. 컨텐츠 검색
    fun searchContent(search: String) {
        todoList.forEachIndexed { index, item ->
            if (item.content.contains(search)) {
                println("$index: ${item.toString()}")
            }
        }
    }

    //4. 컨텐츠 확인.
    fun listTodo() {
        if (todoList.isEmpty()) {
            println("등록된 일정이 없습니다.")
        } else {
            todoList.forEachIndexed { index, item ->
                println("$index : ${item.toString()}")
            }
        }
    }


}