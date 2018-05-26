package com.noman.todolist.test;

import com.noman.todolist.config.SpringRootConfig;

import com.noman.todolist.domain.User;
import com.noman.todolist.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 *
 * @author Noman Ibrahim
 */
public class TestServiceregister {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        User u = new User();
        u.setName("Notun notun");
        u.setPhone("01788464");
        u.setLoginName("fbdfbff");  
        u.setPassword("123654");
        userService.register(u);
        System.out.println("---User DAO updated data");

    }

}
