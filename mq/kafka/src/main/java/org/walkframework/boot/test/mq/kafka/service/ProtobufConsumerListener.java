package org.walkframework.boot.test.mq.kafka.service;

import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;
import org.walkframework.boot.mq.api.AbstractOrderedMessageListener;
import org.walkframework.boot.mq.api.MqListener;
import org.walkframework.boot.mq.api.OrderedMessageListener;
import org.walkframework.boot.test.mq.kafka.model.UserProto;

/**
 * <p>消费者监听</p>
 *
 * @Author mengqk
 * @Since [2023/7/17]
 * @Version 1.0
 */
@Component
@MqListener(topics = {"walk-mq-proto-test"}, profile = "proto")
public class ProtobufConsumerListener implements MessageListener<String, byte[]>, OrderedMessageListener {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void execute(String message, Object detail) {

    }

    public void execute(String message) {

    }

    public void onMessage(ConsumerRecord<String, byte[]> data) {
        try {
            UserProto.User user1 = UserProto.User.parseFrom(data.value());
            logger.info("[test]start consume protobuf message [{}]", user1.getName());
        } catch (InvalidProtocolBufferException e) {
            logger.error("Error parse byte array to UserProto type.", e);
        }
    }
}
