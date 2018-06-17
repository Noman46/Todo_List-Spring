/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.rm;

import com.noman.todolist.domain.Todo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Noman Ibrahim
 */
public class TodoRowMapper implements RowMapper<Todo>{

    @Override
    public Todo mapRow(ResultSet rs, int i) throws SQLException {
       Todo t=new Todo();
       t.setTodoId(rs.getInt("todoId"));
       t.setUserId(rs.getInt("userId"));
       t.setMonth(rs.getString("month"));
       t.setDay(rs.getString("day"));
       t.setYear(rs.getString("year"));
       t.setTitle(rs.getString("title"));
       t.setDescription(rs.getString("description"));
       t.setPriority(rs.getString("priority"));
       return t;
       
    }
    
}
