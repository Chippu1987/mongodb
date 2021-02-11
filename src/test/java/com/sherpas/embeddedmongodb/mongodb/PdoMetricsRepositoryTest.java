package com.sherpas.embeddedmongodb.mongodb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
public class PdoMetricsRepositoryTest {

    @Autowired
    private PdoMetricsRepository pdoMetricsRepository;

    @BeforeEach
    public void dataSetup(){
        PdoMetrics pd1 = new PdoMetrics(1,"Team1","Product1");
        PdoMetrics pd2 = new PdoMetrics(2,"Team2","Product2");
        pdoMetricsRepository.save(pd1);
        pdoMetricsRepository.save(pd2);
        System.out.println(pdoMetricsRepository.findAll());
    }

    @Test
    public void GetTest(){
        System.out.println(pdoMetricsRepository.findAll().size());
        Assertions.assertEquals(2,pdoMetricsRepository.findAll().size());
    }
}
