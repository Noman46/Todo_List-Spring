/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.controller;

import com.noman.todolist.domain.Todo;
import com.noman.todolist.service.TodoService;
import com.noman.todolist.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Noman Ibrahim
 */
@Controller
public class TodoController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoservice;

    @RequestMapping(value = {"/saveAddedTask"})
    public String saveAddedTask(@ModelAttribute("command") Todo todo, Model m, HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");
        todo.setUserId(userId);
        userService.saveTodo(todo);

        return "redirect:todolist?act=worklist";
    }

    @RequestMapping(value = {"/priority"})
    public String givePriority() {

        return "viewTaskByPriority";
    }

    @RequestMapping(value = {"/time"})
    public String giveTimetask() {

        return "viewTaskByTime";
    }

    @RequestMapping(value = {"/todolist"})
    public String goToTodolist(Model m, HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findUserTodo(userId));

        return "todolist";
    }

    @RequestMapping(value = "/del_todolist")
    public String deleteTodoList(@RequestParam("todoId") Integer todoId) {

        todoservice.delete(todoId);
        return "redirect:todolist?act=del";
    }
}
