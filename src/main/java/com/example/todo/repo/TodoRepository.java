package com.example.todo.repo;

import java.util.List;

import javax.transaction.Transactional;

import com.example.todo.entitiy.Todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @Query(value = "select no, title from todo", nativeQuery = true)
    public List<String> findByNoAndTitle();

    public List<Todo> findByno(Integer no);

    //select 문이 아님을 나타낸다
    @Modifying
    @Transactional
    @Query(value = "update todo set title = :title, content = :content where no = :no", nativeQuery = true)
    public void changeToDo(
        @Param("title")
        String title,

        @Param("content")
        String content,

        @Param("no")
        int no
    );
}
