package org.example.logger.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.logger.enums.LogLevel;

@Getter
@Setter
@AllArgsConstructor
public class LogMessage {
    private LogLevel logLevel;
    private String message;
    private Long timestamp;
}
