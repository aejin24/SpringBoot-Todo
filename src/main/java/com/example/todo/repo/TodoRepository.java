package com.example.todo.repo;

import java.util.List;

import com.example.todo.entitiy.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    public List<Todo> findAll();
}
