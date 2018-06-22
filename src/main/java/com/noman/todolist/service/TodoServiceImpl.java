/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.service;

import com.noman.todolist.dao.BaseDAO;
import com.noman.todolist.dao.TodoDAO;
import com.noman.todolist.domain.Todo;
import com.noman.todolist.rm.TodoRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Noman Ibrahim
 */
@Service
public class TodoServiceImpl extends BaseDAO implements TodoService {

    @Autowired
    private TodoDAO todoDao;

    @Override
    public void save(Todo t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Todo t) {
        todoDao.update(t);
    }

    @Override
    public void delete(Integer todoId) {
        todoDao.delete(todoId);
    }

    @Override
    public Todo findById(Integer todoId) {
        return todoDao.findById(todoId);
    }

    @Override
    public List<Todo> findUserTodo(Integer userId) {
        return todoDao.findByProperty("userId", userId);
    }

    @Override
    public List<Todo> findUserTodo(Integer userId, String txt) {
        String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE userId=? AND (month LIKE '%" + txt + "%' OR day LIKE '%" + txt + "%' OR year LIKE '%" + txt + "%' OR title LIKE '%" + txt + "%' OR description LIKE '%" + txt + "%' OR priority LIKE '%" + txt + "%')";
        return getJdbcTemplate().query(sql, new TodoRowMapper(), userId);
    }

    @Override
    public List<Todo> findByPriority(Integer userId) {
        return todoDao.orderByPriority("userId", userId);
    }

    @Override
    public List<Todo> findUserTodoOnlyHigh(Integer userId) {
        String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE userId=? AND priority='a'";
        return getJdbcTemplate().query(sql, new TodoRowMapper(), userId);
    }

    @Override
    public List<Todo> findUserTodoOnlyMedium(Integer userId) {
        String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE userId=? AND priority='b'";
        return getJdbcTemplate().query(sql, new TodoRowMapper(), userId);
    }

    @Override
    public List<Todo> findUserTodoOnlyLow(Integer userId) {
        String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE userId=? AND priority='c'";
        return getJdbcTemplate().query(sql, new TodoRowMapper(), userId);
    }

}
