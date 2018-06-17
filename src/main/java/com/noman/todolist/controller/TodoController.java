/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.controller;

import com.noman.todolist.domain.Todo;
import com.noman.todolist.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Noman Ibrahim
 */
@Controller
public class TodoController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = {"/saveAddedTask"})
    public String saveAddedTask(@ModelAttribute("command") Todo todo, Model m, HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");
        todo.setUserId(userId);
        userService.saveTodo(todo);

        return "todolist";
    }
    
    @RequestMapping(value ={"/priority"})
    public String givePriority(){
    
     return "viewTaskByPriority";
    }
    
     @RequestMapping(value ={"/time"})
    public String giveTimetask(){
    
     return "viewTaskByTime";
    }
}
