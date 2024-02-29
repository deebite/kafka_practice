package com.enduser.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerService {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = AppConstants.LOCATION_UPDATED_MESSAGE,groupId = AppConstants.GROUP_ID)
    public void updateLocation(String value){
        LOG.info("The location are: {}",value);
    }
}
