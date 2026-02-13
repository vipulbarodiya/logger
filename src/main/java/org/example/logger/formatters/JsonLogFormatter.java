package org.example.logger.formatters;

import org.example.logger.enums.LogLevel;
import org.example.logger.models.LogMessage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonLogFormatter {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public String format(LogMessage logMessage) {
        String message = logMessage.getMessage();
        LogLevel logLevel = logMessage.getLogLevel();
        String time = LocalDateTime.ofInstant(Instant.ofEpochMilli(logMessage.getTimestamp()), java.time.ZoneId.systemDefault()).format(formatter);

        return String.format("{ timestamp: %s, logLevel: [%s], message: %s}",time, logLevel, message);
    }
}
