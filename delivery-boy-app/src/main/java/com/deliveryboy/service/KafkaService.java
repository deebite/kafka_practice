package com.deliveryboy.service;

import com.deliveryboy.configuration.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger LOG = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateMessage(String location) {
        for (int i = 0; i < 100000000; i++) {
            kafkaTemplate.send(AppConstants.LOCATION_UPDATED_MESSAGE, location);
            LOG.info("update location {}", location);
        }
        return true;
    }
}
