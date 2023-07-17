package org.walkframework.boot.test.mq.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
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
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,XADataSourceAutoConfiguration.class, KafkaAutoConfiguration.class})
@EnableCaching
@ComponentScan("org.walkframework")
public class KafkaTestApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(KafkaTestApplication.class, args);
        System.in.read();
    }
}
