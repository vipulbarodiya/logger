package org.example.logger.handlers;

import org.example.logger.enums.LogLevel;

public class InfoLogHandler extends LogHandler{

    @Override
    public boolean canHandle(LogLevel logLevel) {
        return logLevel == LogLevel.INFO;
    }
}
