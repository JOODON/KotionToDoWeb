package com.example.kotiontodoweb.controller

import com.example.kotiontodoweb.dto.ToDo
import com.example.kotiontodoweb.service.ToDoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.RequestEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/todo")
class ToDoController {

    @Autowired
    val toDoService = ToDoService();

    @GetMapping("/list")
    fun getAllToDo() : ResponseEntity<List<ToDo>> {
        val todoList = toDoService.findAllToDoList()

        return ResponseEntity.ok(todoList);
    }

    @GetMapping("/list/{todoId}")
    fun getToDoItem(@PathVariable todoId: Long) : ResponseEntity<ToDo>{
        val totoItem = toDoService.getToDoItem(todoId)

        return ResponseEntity.ok(totoItem)
    }

    @PostMapping("/list")
    fun addToDo(@RequestBody todoItem : ToDo) : ResponseEntity<ToDo> {
        println("ID : ${todoItem.id} Status : ${todoItem.status} Title ${todoItem.title}")

//        val addToDoItem = toDoService.addToDoItem(todoItem)

        return ResponseEntity.ok(todoItem);
    }


}