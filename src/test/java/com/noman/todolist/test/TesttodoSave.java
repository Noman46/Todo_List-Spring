/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.test;

import com.noman.todolist.config.SpringRootConfig;
import com.noman.todolist.dao.TodoDAO;
import com.noman.todolist.domain.Todo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Noman Ibrahim
 */
public class TesttodoSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        TodoDAO td = ctx.getBean(TodoDAO.class);
        Todo t = new Todo();
        
        t.setMonth("january");
        t.setDay("23");
        t.setYear("2018");
        t.setTitle("Kemne ki");
        t.setDescription("ghvfh");
        t.setPriority("high");
        td.save(t);
        System.out.println("=====Done Successfully======");
        
        
    }
    
}
