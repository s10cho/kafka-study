package com.study.user.subscribe;

import com.study.share.event.Topics;
import com.study.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@KafkaListener(
    topics = Topics.EVENT_USER,
    groupId = Topics.EVENT_USER + "-subscriber"
)
public class UserEventSubscriber {

    @KafkaHandler
    public void handle(User user) {
        log.debug("user: {}", user);
    }
}
