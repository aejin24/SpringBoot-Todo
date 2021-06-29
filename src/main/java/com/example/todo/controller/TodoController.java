package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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

    
}
