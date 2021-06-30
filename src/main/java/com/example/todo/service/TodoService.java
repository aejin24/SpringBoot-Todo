package com.example.todo.service;

import java.util.List;

import com.example.todo.entitiy.Todo;

public interface TodoService {

    public List<String> findToDo();

    public void saveToDo(String title, String content);

    public List<Todo> findOneToDo(Integer no);

    public void deleteToDo(Integer no);
}
