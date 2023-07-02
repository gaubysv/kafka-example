package com.example.kafka.management.service;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class KafkaManagementService {

    private final AdminClient kafkaAdminClient;

    public Set<String> getTopics() throws ExecutionException, InterruptedException {
        return kafkaAdminClient.listTopics().names().get();
    }
}
