package com.lzz.middleware.listener;

import com.lzz.middleware.dto.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "test", groupId = "test-consumer")
    public void listen(KafkaMessage message) {
        logger.info("接收消息: {}", message);
    }


}