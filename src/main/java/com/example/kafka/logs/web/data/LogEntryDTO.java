package com.example.kafka.logs.web.data;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogEntryDTO implements Serializable {

    private static final long serialVersionUID = 8640543677380113982L;

    private String type;
    private String value;
}
