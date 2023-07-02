package com.example.kafka.async;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;

import static com.example.kafka.logs.service.LogsConstants.LOGS_TOPIC;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogEntryEventConsumer {

    private final ExecutorService logEntryExecutorService;

    private final KafkaConsumer<String, String> kafkaConsumer;

    @PostConstruct
    public void consume() {
        logEntryExecutorService.submit(() -> {
            kafkaConsumer.subscribe(Collections.singletonList(LOGS_TOPIC));
            Duration timeout = Duration.ofMillis(100);
            while (true) {
                ConsumerRecords<String, String> records = kafkaConsumer.poll(timeout);

                for (ConsumerRecord<String, String> record : records) {
                    log.info("Key: {}, value: {}", record.key(), record.value());
                }
            }
        });
    }
}
