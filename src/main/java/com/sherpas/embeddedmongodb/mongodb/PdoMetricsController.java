package com.sherpas.embeddedmongodb.mongodb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pdoMetrics")
public class PdoMetricsController {

    private static final Logger log = LogManager.getLogger("PDO Metric Controller");

    @Autowired
    private PdoMetricsService pdoMetricsService;

    @PostMapping(consumes = "application/json", produces="application/json")
    public ResponseEntity<String> acceptMetricsData(PdoMetrics pdoMetrics){
        log.info("acceptedMetricsData: accepted {}",pdoMetrics);
        pdoMetricsService.createOrUpdateMetricsData(pdoMetrics);
        return new ResponseEntity<>("Metrics accepted",null, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<PdoMetrics> getAllMetricsData(){
       return pdoMetricsService.getAllMetricsData();
    }
}
