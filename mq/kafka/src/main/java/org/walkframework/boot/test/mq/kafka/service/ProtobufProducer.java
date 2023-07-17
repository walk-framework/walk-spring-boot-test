package org.walkframework.boot.test.mq.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.walkframework.boot.mq.api.MqOrderedProducer;
import org.walkframework.boot.test.mq.kafka.model.UserProto;

/**
 * <p>生产者</p>
 *
 * @Author mengqk
 * @Since [2019/1/14]
 * @Version 1.0
 */
@Component
@EnableScheduling
public class ProtobufProducer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private KafkaTemplate<String, byte[]> protoKafkaTemplate;

    private int counter = 0;

    @Scheduled(fixedRate = 5000)
    public void produce() {
        UserProto.User.Builder user = new UserProto.User.Builder();
        user.setAge(++counter);
        user.setName("Jack" + user.getAge());
        user.setId(user.getAge());
        byte[] message = user.build().toByteArray();
        logger.info("[test] start send protobuf message [{}]", user.getName());
        protoKafkaTemplate.send("walk-mq-proto-test", "test", message);
    }
}
