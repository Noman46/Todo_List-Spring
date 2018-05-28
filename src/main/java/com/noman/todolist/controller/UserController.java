/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Noman Ibrahim
 */
@Controller
public class UserController {
    @RequestMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = {"/register"})
    public String register(){
        return "register";
    }
}
