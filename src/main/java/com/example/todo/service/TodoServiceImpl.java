package com.example.todo.service;

import com.example.todo.entitiy.Todo;
import com.example.todo.repo.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    
    @Autowired
    private TodoRepository tRepository;

    //createToDo
    public void saveToDo(String title, String content){
        Todo todo = new Todo(title, content);
        tRepository.save(todo);
    }

    //selectToDo
    public List<String> findToDo(){
        List<String> todos = tRepository.findByNoAndTitle();
        return todos;
    }

    //selectToDo where id
    public List<Todo> findOneToDo(Integer no){
        List<Todo> todos = tRepository.findByno(no);
        return todos;
    }

    //deleteToDo where id
    public void deleteToDo(Integer no){
        tRepository.deleteById(no);
    }

    //updateToDo where id
    public void updateToDo(String title, String content, Integer no){
        tRepository.changeToDo(title, content, no);
    }
}
