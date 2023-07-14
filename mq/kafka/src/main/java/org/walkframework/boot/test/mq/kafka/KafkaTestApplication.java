package org.walkframework.boot.test.mq.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

/**
 * <p>类描述</p>
 *
 * @Author mengqk
 * @Since [2019/1/14]
 * @Version 1.0
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,XADataSourceAutoConfiguration.class})
@EnableCaching
@ComponentScan("org.walkframework")
public class KafkaTestApplication {

    public static void main(String[] args) throws IOException {
        // Field field = ReflectionUtils.findField(ConsumerConfig.class, "CONFIG");
        // ReflectionUtils.makeAccessible(field);
        // ConfigDef configDef = (ConfigDef) ReflectionUtils.getField(field, null);
        // configDef.define("sasl.jaas.config", ConfigDef.Type.STRING, (Object)null, ConfigDef.Importance.MEDIUM, "The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config.");
        SpringApplication.run(KafkaTestApplication.class, args);
        //SpringContextHolder.getBean("icaKafkaTemplate", KafkaTemplate.class).send("test", "test1Value");
        System.in.read();
    }
}
