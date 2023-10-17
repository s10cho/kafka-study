package com.study.user.publisher;

import java.io.Serializable;

import com.study.share.event.Topics;
import com.study.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventPublisher {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    public void send(User user) {
        kafkaTemplate.send(
            Topics.EVENT_USER,
            Long.toString(user.getId()),
            user
        );
    }
}
