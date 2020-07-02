package com.lessons;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

public class Queries
{
    private static final Logger logger = LoggerFactory.getLogger(Queries.class);

    private DataSource dataSource = null;

    public Queries(String username, String password, String url){
        logger.debug("constructor #2 is called.");

        //no longer needed- as the datasource is now created in the main app and passed in here below
//        SingleConnectionDataSource ds  =new SingleConnectionDataSource();
//        ds.setUsername(username);
//        ds.setPassword(password);
//        ds.setUrl(url);

//        this.dataSource = ds;
    }

    public Queries(DataSource aDataSource)
    {
        logger.debug("Inside the single-arg contstructor in Queries");

        if(aDataSource == null)
        {
            logger.error("The datasource was null.");
            throw new RuntimeException("The datasource passed in was null.");
        }

        this. dataSource = aDataSource;
    }

    public String getDatabaseTime() {
        logger.debug("getDatabaseTime() started.");


        // Create a new JdbcTemplate object   [needs the data source]
        JdbcTemplate jt = new JdbcTemplate(dataSource);
        String sql = "Select now()";

        // Use the JdbcTemplate object to run a query and get a result
        String databaseTime = jt.queryForObject(sql, String.class);

        // Return the string
        logger.debug("getDatabaseTime() returns {}", databaseTime);
        return databaseTime;
    }
}