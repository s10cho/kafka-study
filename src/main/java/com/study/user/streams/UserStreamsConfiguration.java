package com.study.user.streams;

import com.study.share.event.Topics;
import com.study.user.domain.User;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@Configuration(proxyBeanMethods = false)
@EnableKafkaStreams
public class UserStreamsConfiguration {

    @Bean
    public KStream<String, User> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, User> stream = streamsBuilder.stream(Topics.EVENT_USER);
        stream.map(this::toggleMember).to(Topics.EVENT_MEMBER);
        return stream;
    }

    private KeyValue<String, User> toggleMember(String key, User user) {
        user.toggleMember();
        return new KeyValue<>(key, user);
    }
}
