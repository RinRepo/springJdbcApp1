package com.lessons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class AggService {
    private static final Logger logger = LoggerFactory.getLogger(AggService.class);

    private UserService userService = null;
    private ReportService reportService = null;
    private IndicatorService indicatorService = null;

    public AggService(UserService userService, ReportService reportService, IndicatorService indicatorService) {

        logger.debug("Constructor in AggService is called.");

        this.userService = userService;
        this.reportService = reportService;
        this.indicatorService = indicatorService;

    }

    public AggsDTO getAggs() {
//        Map<String, Integer> map = new HashMap<>();


        Integer reportCount = this.reportService.getCount();
        Integer userCount = this.userService.getCount();

//creates the object
        AggsDTO aggsDTO = new AggsDTO();
//        aggsDTO.setTotalUsers(userCount);
        aggsDTO.setTotalReports(reportCount);

        return aggsDTO;

// config for using a map
//    public Map<String,Integer> getAggs(){
//        Map<String,Integer> map = new HashMap<>();

//        map.put("total_reports", reportCount);
//        map.put("total_users", userCount);
//        map.put("total_indicators", 3);
//        return map;

    }

}
