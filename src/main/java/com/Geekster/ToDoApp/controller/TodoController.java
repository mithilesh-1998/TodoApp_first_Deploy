package com.Geekster.ToDoApp.controller;

import com.Geekster.ToDoApp.Service.TodoService;
import com.Geekster.ToDoApp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    public TodoController() {
    }

    @GetMapping("todos")
    public List<Todo> getAllTodos() {

        return todoService.getAllTodos();
    }

    @GetMapping("todo/done")
    public List<Todo> getDoneTodos() {
        return todoService.getalldonetodos();
    }

    @GetMapping("todo/undone")
    public List<Todo> getNotDoneTodos() {

        return todoService.getallundonetodos();
    }

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo)
    {

        return todoService.addTodos(todo);
    }

    @PutMapping("todo/{todoId}/{status}")
    public String markTodo(@PathVariable Integer todoId,@PathVariable boolean status) {
        return todoService.markTodos(todoId, status);
    }

    @DeleteMapping("todo")
    public String removeTodo(@RequestParam Integer todoId)
    {
        return todoService.removeTodos(todoId);

    }
}
