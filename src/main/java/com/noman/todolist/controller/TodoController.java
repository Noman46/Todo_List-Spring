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
    public String saveOrUpdateAddedTask(@ModelAttribute("command") Todo todo, Model m, HttpSession session) {
        Integer todoId = (Integer) session.getAttribute("pTodoId");
        if (todoId == null) {
            Integer userId = (Integer) session.getAttribute("userId");
            todo.setUserId(userId);
            userService.saveTodo(todo);

            return "redirect:todolist?act=worklist";
        } else {
            todo.setTodoId(todoId);
            todoservice.update(todo);
            return "redirect:todolist?act=worklist";

        }

    }

    @RequestMapping(value = {"/saveAddedTaskPriority"})
    public String updateAddedTask(@ModelAttribute("command") Todo todo, Model m, HttpSession session) {
        Integer todoId = (Integer) session.getAttribute("pTodoId");

        todo.setTodoId(todoId);
        todoservice.update(todo);
        return "redirect:priority?act=update";

    }

    @RequestMapping(value = {"/priority"})
    public String givePriority(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findByPriority(userId));
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

    @RequestMapping(value = "/del_todolist_priority")
    public String deleteTodoListPriority(@RequestParam("todoId") Integer todoId) {

        todoservice.delete(todoId);
        return "redirect:priority?act=del";
    }

    @RequestMapping(value = {"/edit_todolist"})
    public String editList(Model m, HttpSession session, @RequestParam("todoId") Integer todoId) {

        session.setAttribute("pTodoId", todoId);
        Todo t = todoservice.findById(todoId);
        m.addAttribute("command", t);
        return "addNewTask";
    }

    @RequestMapping(value = {"/edit_todolist_priority"})
    public String editListPriority(Model m, HttpSession session, @RequestParam("todoId") Integer todoId) {

        session.setAttribute("pTodoId", todoId);
        Todo t = todoservice.findById(todoId);
        m.addAttribute("command", t);
        return "addNewTaskPriority";
    }

    @RequestMapping(value = {"/search"})
    public String search(Model m, HttpSession session, @RequestParam("freetext") String freetext) {

        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findUserTodo(userId, freetext));
        return "todolist";
    }

    @RequestMapping(value = {"/search_priority"})
    public String searchPriority(Model m, HttpSession session, @RequestParam("freetext") String freetext) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findUserTodo(userId, freetext));
        return "viewTaskByPriority";
    }

    @RequestMapping(value = {"/High"})
    public String searchPriorityHigh(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findUserTodoOnlyHigh(userId));
        return "viewTaskByPriority";
    }

    @RequestMapping(value = {"/Medium"})
    public String searchPriorityMedium(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findUserTodoOnlyMedium(userId));
        return "viewTaskByPriority";
    }

    @RequestMapping(value = {"/Low"})
    public String searchPriorityLow(Model m, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("todolists", todoservice.findUserTodoOnlyLow(userId));
        return "viewTaskByPriority";
    }

}
