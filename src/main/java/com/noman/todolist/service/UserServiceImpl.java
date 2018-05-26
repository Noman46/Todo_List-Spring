/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.service;

import com.noman.todolist.dao.BaseDAO;
import com.noman.todolist.dao.UserDAO;
import com.noman.todolist.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Noman Ibrahim
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService{

    @Autowired
    private UserDAO userDao;
    
    @Override
    public void register(User u) {
       userDao.save(u);
    }
    
}
