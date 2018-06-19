/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.dao;

import com.noman.todolist.domain.Todo;
import java.util.List;

/**
 *
 * @author Noman Ibrahim
 */
public interface TodoDAO {

    public void save(Todo todo);

    public void update(Todo todo);

    public void delete(Todo todo);

    public void delete(Integer todoId);

    public Todo findById(Integer todoId);

    public List<Todo> findAll();

    public List<Todo> findByProperty(String propName, Object propValue);

    public List<Todo> orderByPriority(String propName, Object propValue);

}
