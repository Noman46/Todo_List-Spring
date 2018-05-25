package com.noman.todolist.test;

import com.noman.todolist.config.SpringRootConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

/**
 *
 * @author Noman Ibrahim
 */
public class TestDataSource {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql ="INSERT INTO USER(`name`,`phone`,`loginName`,`password`)" + "VALUES(?,?,?,?,)";
        Object [] param = new Object[]{"Muhammad Noman","01789298773","noman","123"};
        jt.update(sql, param);
        System.out.println("---- Data Inserted----");
        
        
    }

}
