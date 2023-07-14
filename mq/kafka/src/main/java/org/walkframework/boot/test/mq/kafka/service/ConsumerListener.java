package org.walkframework.boot.test.mq.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.walkframework.boot.mq.api.AbstractOrderedMessageListener;
import org.walkframework.boot.mq.api.MqListener;

/**
 * <p>消费者监听</p>
 *
 * @Author mengqk
 * @Since [2019/1/14]
 * @Version 1.0
 */
@Component
@MqListener(topics = {"walk-mq-test"})
public class ConsumerListener extends AbstractOrderedMessageListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute(String message) {
        logger.info("[test]start consume message [{}]", message);
    }
}
