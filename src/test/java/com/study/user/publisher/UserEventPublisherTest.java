package com.study.user.publisher;

import java.util.concurrent.TimeUnit;

import com.study.share.event.Topics;
import com.study.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@Slf4j
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(
    partitions = 1,
    topics = {
        Topics.EVENT_USER,
        Topics.EVENT_MEMBER,
    },
    brokerProperties = {
        "listeners=PLAINTEXT://localhost:9092",
        "port=9092"
    }
)
class UserEventPublisherTest {

    @Autowired
    UserEventPublisher userEventPublisher;

    @Test
    void sendTest() throws InterruptedException {
        userEventPublisher.send(new User(1, "홍길동", false));

        TimeUnit.SECONDS.sleep(3);
    }
}
