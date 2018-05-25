
package com.noman.todolist.test;

import com.noman.todolist.config.SpringRootConfig;
import com.noman.todolist.dao.UserDAO;
import com.noman.todolist.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Noman Ibrahim
 */
public class TestuserDaoSave {

    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAo = ctx.getBean(UserDAO.class);
        User u = new User();
        u.setName("Muhammad");
        u.setPhone("01788464");
        u.setLoginName("fbdfbfb");
        u.setPassword("123654");
        userDAo.save(u);
        System.out.println("---User DAO updated data");
       // System.out.println(u.getUserId());
        
       
    }
    
}
