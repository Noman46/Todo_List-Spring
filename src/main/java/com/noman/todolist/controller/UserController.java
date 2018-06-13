/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.controller;

import com.noman.todolist.command.LoginCommand;
import com.noman.todolist.command.RegCommand;
import com.noman.todolist.domain.Todo;
import com.noman.todolist.domain.User;
import com.noman.todolist.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/aboutme"})
    public String getAboutMe() {
        return "aboutme"; // Return About me JSP page
    }

    @RequestMapping(value = {"/reg_form"})
    public String register(Model m) {
        RegCommand cmd = new RegCommand();
        m.addAttribute("command", cmd);
        return "register";
    }

    @RequestMapping(value = {"/register"})
    public String registerUser(@ModelAttribute("command") RegCommand cmd, Model m) {
        User u = cmd.getU();
        userService.register(u);

        return "redirect:loginform?act=reg"; // Redirecting means not to show JSP page rather it redirects to the "index" action handeler
    }

    @RequestMapping(value = {"/loginform"})
    public String loginForm(Model m) {
        LoginCommand cmd = new LoginCommand();
        m.addAttribute("command", cmd);
        return "login";
    }

    @RequestMapping(value = {"/logindo"})
    public String logindo(@ModelAttribute("command") LoginCommand cmd) {
       userService.login(cmd.getLoginName(), cmd.getPassword());
        return "redirect:addTask?act=taskpage";
    }
    
    @RequestMapping(value = {"/addTask"})
    public String addTask(Model m){
    Todo todo = new Todo();
    m.addAttribute("command", todo);
    
    return "addNewTask";
    }
    
   


}
