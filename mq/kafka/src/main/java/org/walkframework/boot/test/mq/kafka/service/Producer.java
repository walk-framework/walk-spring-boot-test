package org.walkframework.boot.test.mq.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.walkframework.boot.mq.api.MqOrderedProducer;

/**
 * <p>生产者</p>
 *
 * @Author mengqk
 * @Since [2019/1/14]
 * @Version 1.0
 */
@Component
@EnableScheduling
public class Producer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MqOrderedProducer baseMqOrderedProducer;

    private int counter = 0;

    @Scheduled(fixedRate = 5000)
    public void produce() {
        String message = "this is a test message by order " + (++counter);
        logger.info("[test] start send message [{}]", message);
        baseMqOrderedProducer.send("walk-mq-test", "test", message);
    }
}
