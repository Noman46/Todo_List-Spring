/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.noman.todolist.domain;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Noman Ibrahim
 */
public class Todo {
    
    private Integer todoId;
    private Integer userId;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;
    private String title;
    private String description;
    private String priority;
    
    public Todo(){
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Todo{" + "todoId=" + todoId + ", userId=" + userId + ", date=" + date + ", title=" + title + ", description=" + description + ", priority=" + priority + '}';
    }
    
    
    
    
}
