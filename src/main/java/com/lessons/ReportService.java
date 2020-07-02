package com.lessons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

public class ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);

    private DataSource dataSource = null;

    public ReportService(String username, String password, String url){
        logger.debug("constructor #2 is called.");

        SingleConnectionDataSource ds  =new SingleConnectionDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setUrl(url);

        this.dataSource = ds;
    }

    public ReportService(DataSource aDataSource)
    {
        logger.debug("Inside the single-arg contstructor in ReportService");

        if(aDataSource == null)
        {
            logger.error("The datasource was null.");
            throw new RuntimeException("The datasource passed in was null.");
        }

        this. dataSource = aDataSource;
    }

    //public method
    public int getStuffCount(){
        logger.debug("Started getStuffCount()");
        //needed in order to run sql
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        String sql = "select count(*) from stuff";

        Integer count = jt.queryForObject(sql, Integer.class);
        return count;
    }

    public int getCount(){
        logger.debug("Started getCount()");
        //needed in order to run sql
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        String sql = "select count(*) from reports";

        Integer count = jt.queryForObject(sql, Integer.class);
        return count;
    }

}
