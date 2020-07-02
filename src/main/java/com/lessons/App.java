package com.lessons;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.util.List;
import java.util.Map;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);


    /**********************************************************
     * main()
     *
     * Main program to access this class from the command-line
     ********************************************************** */
    public static void main(String[] args)
    {
        // Program starts here
        logger.debug("main() started");

        //un-comment the line below for testing runtime exception error if statement, when datasource is null
        //SingleConnectionDataSource ds = null;

        //comment out the 4 lines below IF line above is NOT commented out
//        SingleConnectionDataSource ds  =new SingleConnectionDataSource();
//        ds.setUsername("test1");
//        ds.setPassword("test");
//        ds.setUrl("jdbc:postgresql://localhost:5432/test1");

        // Create data source that holds a C3P0 connection pool
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setUser("test1");
        ds.setPassword("test");
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/test1");
        ds.setInitialPoolSize(1);
        ds.setMaxPoolSize(10);

        // Instantiate a new Queries object
        Queries q = new Queries(ds);


        //Instantiate a new Report Service Object
        ReportService rs = new ReportService(ds);
        int countOfStuff = rs.getStuffCount();
        logger.debug("The count is {}",countOfStuff);

        int reportCount = rs.getCount();
        logger.debug("The report count is {}", reportCount);

        //Instantiate UserService
        UserService us = new UserService(ds);
        int userCount = us.getCount();
        logger.debug("The user count is {}", userCount);

        //Instantiate IndicatorService
        IndicatorService is = new IndicatorService(ds);

        List<IndicatorDTO> listOfIndicators = is.getAllIndicators();
        for(IndicatorDTO currentIndicator : listOfIndicators)
        {
            logger.debug("current indicator list id: {} type: {} value: {}", currentIndicator.getId(), currentIndicator.getType(), currentIndicator.getValue());
        }

        //Instantiate AggService
        AggService as = new AggService(us, rs, is);
        AggsDTO aggsDTO = as.getAggs();
//        Map<String,Integer> aggsMap = as.getAggs();



        //logger call that will display total reports
        Integer countAllReports = aggsDTO.getTotalReports();
        logger.debug("Total reports is : {}", countAllReports);

        // Use the Queries object to get the current database time as a string
        String currentTime = q.getDatabaseTime();


        // Print out the current database time
        System.out.println("Current Database Time is " + currentTime);

        // Program ends Here
        logger.debug("main() finished."




        );

    }


}

