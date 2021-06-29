package com.example.todo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TodoController {
    
    @GetMapping("/")
    public String main() {
        return "main";
    }
    
    @GetMapping("/todo")
    public String todo() {
        return "todo";
    }

    @ResponseBody
    @PostMapping("/todo/newToDo")
    public void newToDo(HttpServletRequest request){
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        System.out.println(title + " : " + content);
    }
}
