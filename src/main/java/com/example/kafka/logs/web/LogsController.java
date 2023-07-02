package com.example.kafka.logs.web;

import com.example.kafka.logs.service.LogsService;
import com.example.kafka.logs.web.data.LogEntryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogsController {

    private final LogsService logsService;

    @PostMapping
    public void save(@RequestBody LogEntryDTO logEntry) throws Exception {
        logsService.save(logEntry);
    }
}
