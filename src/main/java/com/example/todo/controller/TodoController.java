package com.example.todo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.todo.entitiy.Todo;
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
        List<String> tlist = tService.findToDo();

        //저장된 todo가 있을 때만 model 추가
        if(tlist.size() > 0){
            model.addAttribute("tlist", tlist);
        }else {
            System.out.println("---------------------------");
            System.out.println("empty todo list");
            System.out.println("---------------------------");
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

    @GetMapping("/todo/info")
    public String todoInfo(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));

        List<Todo> ftodo = tService.findOneToDo(id);
        model.addAttribute("title", ftodo.get(0).getTitle());
        model.addAttribute("content", ftodo.get(0).getContent());

        return "todoInfo";
    }

    @ResponseBody
    @PostMapping("/todo/delete")
    public void deleteToDo(HttpServletRequest request){
        int no = Integer.parseInt(request.getParameter("id"));
        
        tService.deleteToDo(no);
    }

    @GetMapping("/todo/modify")
    public String modifyToDo(HttpServletRequest request, Model model){
        int no = Integer.parseInt(request.getParameter("id"));

        List<Todo> fTodos = tService.findOneToDo(no);
        model.addAttribute("title", fTodos.get(0).getTitle());
        model.addAttribute("content", fTodos.get(0).getContent());

        return "todoModify";
    }

    @ResponseBody
    @PostMapping("/todo/update")
    public void updateToDo(HttpServletRequest request){
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int no = Integer.parseInt(request.getParameter("id"));

        tService.updateToDo(title, content, no);
    }
}
