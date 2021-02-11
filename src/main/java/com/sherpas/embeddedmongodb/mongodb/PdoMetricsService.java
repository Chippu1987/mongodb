package com.sherpas.embeddedmongodb.mongodb;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PdoMetricsService {
    @Autowired
    PdoMetricsRepository pdoMetricsRepository;

    public PdoMetrics createOrUpdateMetricsData(PdoMetrics pdoMetrics) {
       return pdoMetricsRepository.save(pdoMetrics);
    }

    public List<PdoMetrics> getAllMetricsData() {
        return pdoMetricsRepository.findAll();
    }
}
