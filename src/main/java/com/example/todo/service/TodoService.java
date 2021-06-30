package com.example.todo.service;

import java.util.List;

public interface TodoService {

    public List<String> findToDo();

    public void saveToDo(String title, String content);
}
