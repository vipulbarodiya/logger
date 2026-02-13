package org.example.logger.formatters;

import org.example.logger.enums.LogLevel;
import org.example.logger.models.LogMessage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TextLogFormatter implements LogFormatter {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    @Override
    public String format(LogMessage logMessage) {
        String message = logMessage.getMessage();
        LogLevel logLevel = logMessage.getLogLevel();
        String time = LocalDateTime.ofInstant(Instant.ofEpochMilli(logMessage.getTimestamp()), java.time.ZoneId.systemDefault()).format(formatter);

        return String.format("%s-[%s]-%s", time, logLevel,  message);
    }
}
