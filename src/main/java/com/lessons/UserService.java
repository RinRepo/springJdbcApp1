package com.lessons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private DataSource dataSource = null;

    public UserService(DataSource aDataSource)
    {
        logger.debug("Inside the single-arg contstructor in UserService");

        if(aDataSource == null)
        {
            logger.error("The datasource was null.");
            throw new RuntimeException("The datasource passed in was null Why you do dis?");
        }

        this. dataSource = aDataSource;
    }

    public int getCount(){
        logger.debug("Started getCount()");
        //needed in order to run sql
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        String sql = "select count(*) from users";

        Integer count = jt.queryForObject(sql, Integer.class);
        return count;
    }
}
