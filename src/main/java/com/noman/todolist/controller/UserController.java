/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.controller;

import com.noman.todolist.command.RegCommand;
import com.noman.todolist.domain.User;
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

    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/reg_form"})
    public String register(Model m) {
       RegCommand cmd=new RegCommand();
        m.addAttribute("command", cmd);
        return "register";
    }

    @RequestMapping(value = {"/register"})
    public String registerUser(@ModelAttribute("command") RegCommand cmd, Model m) {
        User u = cmd.getU();
        return "redirect:index";
    }
}
