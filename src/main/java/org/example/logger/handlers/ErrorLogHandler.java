package org.example.logger.handlers;

import org.example.logger.enums.LogLevel;

public class ErrorLogHandler extends LogHandler{

    @Override
    public boolean canHandle(LogLevel logLevel) {
        return logLevel == LogLevel.ERROR;
    }
}
