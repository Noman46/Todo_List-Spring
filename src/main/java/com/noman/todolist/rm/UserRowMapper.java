/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.rm;

import com.noman.todolist.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Noman Ibrahim
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setLoginName(rs.getString("loginName"));
       
        return u;
    }

}
