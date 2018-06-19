/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.dao;

import com.noman.todolist.domain.Todo;
import com.noman.todolist.rm.TodoRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Noman Ibrahim
 */
@Repository
public class TodoDAOImpl extends BaseDAO implements TodoDAO {

    @Override
    public void save(Todo todo) {
        String sql = "INSERT INTO todo (userId,month,day,year,title,description,priority) VALUES (:userId, :month, :day, :year, :title, :description, :priority)";
        Map m = new HashMap();
        m.put("userId", todo.getUserId());
        m.put("month", todo.getMonth());
        m.put("day", todo.getDay());
        m.put("year", todo.getYear());
        m.put("title", todo.getTitle());
        m.put("description", todo.getDescription());
        m.put("priority", todo.getPriority());
        
        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer todoId = kh.getKey().intValue();
        todo.setTodoId(todoId);
        

    }

    @Override
    public void update(Todo todo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Todo todo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer todoId) {
     String sql = "DELETE FROM todo WHERE todoId=?";
     getJdbcTemplate().update(sql, todoId);
    }

    @Override
    public Todo findById(Integer todoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Todo> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Todo> findByProperty(String propName, Object propValue) {
      String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE "+propName+"=?";
      return getJdbcTemplate().query(sql, new TodoRowMapper(), propValue);
    }
    
    @Override
    public List<Todo> orderByPriority(String propName, Object propValue) {
      String sql = "SELECT todoId, userId, month, day, year, title, description, priority FROM todo WHERE "+propName+"=? ORDER BY priority";
      return getJdbcTemplate().query(sql, new TodoRowMapper(), propValue);
    }

}
