package com.example.kotiontodoweb.service

import com.example.kotiontodoweb.dto.ToDo
import org.springframework.stereotype.Service


@Service
class ToDoService{

    val todoList : List<ToDo> = listOf(
        ToDo("TODO List Col 1" , "진행중",1),
        ToDo("TODO List Col 2" , "진행중",2),
        ToDo("TODO List Col 3" , "완료",3),
        ToDo("TODO List Col 4" , "완료",4)
    )

    fun findAllToDoList() : List<ToDo>{

        return todoList
    }

    fun getToDoItem(id : Long) : ToDo? {
        return todoList.find { it.id == id }
    }
}