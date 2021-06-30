package com.example.todo.repo;

import java.util.List;

import com.example.todo.entitiy.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query(value = "select no, title from todo", nativeQuery = true)
    public List<String> findByNoAndTitle();
}
