package com.lessons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class IndicatorService {
    private static final Logger logger = LoggerFactory.getLogger(IndicatorService.class);

    private DataSource dataSource = null;

    public IndicatorService(DataSource aDataSource) {
        logger.debug("Inside the single-arg contstructor in Indicator Service");

        if (aDataSource == null) {
            logger.error("The datasource was null.");
            throw new RuntimeException("The datasource passed in was null Why you do dis?");
        }

        this.dataSource = aDataSource;
    }

    public List<IndicatorDTO> getAllIndicators() {
        logger.debug("Started getAllIndicators()");
//        return null;
        JdbcTemplate jt = new JdbcTemplate(this.dataSource);
        BeanPropertyRowMapper rowMapper = new BeanPropertyRowMapper(IndicatorDTO.class);

        String sql = "select id, type, value from indicators;";
        List<IndicatorDTO> listOfIndicators = jt.query(sql, rowMapper);

        return listOfIndicators;

    }



}
