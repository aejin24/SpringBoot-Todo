package com.example.todo.service;

import java.util.List;

import com.example.todo.entitiy.Todo;

public interface TodoService {

    public List<Todo> findToDoAll();

    public void saveToDo(String title, String content);
}
