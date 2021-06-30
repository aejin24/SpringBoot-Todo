package com.example.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.todo.service.TodoService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService tService;
    
    @GetMapping("/")
    public String main(Model model) {
        tService.findToDo();
        List<String> tlist = tService.findToDo();

        //저장된 todo가 있을 때만 model 추가
        if(tlist.size() > 1){
            model.addAttribute("tlist", tlist);
        }

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

        tService.saveToDo(title, content);
    }
}
