package com.example.kafka.management.web;

import com.example.kafka.management.service.KafkaManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafka/management")
@RequiredArgsConstructor
public class KafkaManagementController {

    private final KafkaManagementService kafkaManagementService;

    @GetMapping("/topics")
    public Set<String> getTopics() throws ExecutionException, InterruptedException {
        return kafkaManagementService.getTopics();
    }
}
