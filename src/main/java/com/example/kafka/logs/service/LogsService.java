package com.example.kafka.logs.service;

import com.example.kafka.logs.web.data.LogEntryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import static com.example.kafka.logs.service.LogsConstants.LOGS_TOPIC;

@Slf4j
@Service
@RequiredArgsConstructor
public class LogsService {

    private final KafkaProducer<String, String> kafkaProducer;

    private final LogEntrySendCallback logEntrySendCallback;

    private final ObjectMapper objectMapper;

    public void save(LogEntryDTO logEntry) throws Exception {
        ProducerRecord<String, String> record = new ProducerRecord<>(LOGS_TOPIC, objectMapper.writeValueAsString(logEntry));
        try {
            kafkaProducer.send(record, logEntrySendCallback);
        } catch (Exception e) {
            log.error("Failed to send log entry to kafka.", e);
        }
    }
}
