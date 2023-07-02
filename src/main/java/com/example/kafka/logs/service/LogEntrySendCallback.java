package com.example.kafka.logs.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogEntrySendCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (e != null) {
            log.error("Failed to send log entry to kafka.", e);
        } else {
            log.info("Successfully sent log entry to kafka [" + recordMetadata + "].");
        }
    }
}
