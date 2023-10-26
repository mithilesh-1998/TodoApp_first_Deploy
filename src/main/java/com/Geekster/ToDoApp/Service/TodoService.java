package com.Geekster.ToDoApp.Service;

import com.Geekster.ToDoApp.Repository.TodoRepo;
import com.Geekster.ToDoApp.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepo todoRepo;

    public List<Todo> getAllTodos() {

        return todoRepo.getMyTodos();
    }
    public List<Todo> getalldonetodos(){
        List<Todo> doneTodos = new ArrayList<>();
        for(Todo myTodo : todoRepo.getMyTodos())
        {
            if(myTodo.isTodoDoneStatus()) {
                doneTodos.add(myTodo);
            }
        }

        return doneTodos;
    }
    public List<Todo> getallundonetodos(){
        List<Todo> unDoneTodos = new ArrayList<>();
        for(Todo myTodo : todoRepo.getMyTodos()) {
            if(!myTodo.isTodoDoneStatus()) {
                unDoneTodos.add(myTodo);
            }
        }
        return unDoneTodos;
    }

    public String addTodos(Todo mytodos){
        todoRepo.add(mytodos);
        return "Todo added";
    }

    public String markTodos(Integer todoId, boolean status){
        for(Todo myTodo : todoRepo.getMyTodos()) {
            if(myTodo.getTodoId().equals(todoId)) {
                myTodo.setTodoDoneStatus(status);
                return "todo updated for todo ID:" + todoId;
            }
        }
        return "todo not found todo ID: " + todoId;

    }

    public String removeTodos(Integer todoId){
        for(Todo myTodo : todoRepo.getMyTodos())
        {
            if(myTodo.getTodoId().equals(todoId))
            {
                todoRepo.remove(myTodo);
                return "todo removed for todo ID:" + todoId;
            }
        }
        return "todo :" + todoId + " not deleted as it doesn't exist" ;
    }
}
