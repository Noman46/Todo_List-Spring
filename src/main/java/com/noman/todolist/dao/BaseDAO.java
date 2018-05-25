
package com.noman.todolist.dao;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 *
 * @Noman Ibrahim
 * 
 */
// Do not use @Repositry or @Service Or @Component
// Because This class will not indipendently exist in the Spring IOC
 abstract public class BaseDAO extends NamedParameterJdbcDaoSupport{
    @Autowired
    public void setDataSource2(DataSource ds){
         super.setDataSource(ds);
    }
    
}
