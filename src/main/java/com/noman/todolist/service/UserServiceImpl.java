/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.service;

import com.noman.todolist.dao.BaseDAO;
import com.noman.todolist.dao.TodoDAO;
import com.noman.todolist.dao.UserDAO;
import com.noman.todolist.domain.Todo;
import com.noman.todolist.domain.User;
import com.noman.todolist.rm.UserRowMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Noman Ibrahim
 */
@Service
public class UserServiceImpl extends BaseDAO implements UserService {

    @Autowired
    private UserDAO userDao;
    
    @Autowired
    private TodoDAO todoDao;

    @Override
    public void register(User u) {
        userDao.save(u);
    }

    @Override
    public User login(String loginName, String password) {
        String sql = "SELECT userid, name, phone,loginName FROM user WHERE loginName=:ln AND password=:pw";
        Map m = new HashMap();
        m.put("ln", loginName);
        m.put("pw", password);
        try{
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            return u;
        } catch(EmptyResultDataAccessException ex)
        {
        return null;
        }
        

    }

    @Override
    public void saveTodo(Todo t) {
       todoDao.save(t);
    }

}
