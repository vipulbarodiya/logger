package org.example.logger.handlers;

import org.example.logger.enums.LogLevel;

public class DebugLogHandler extends LogHandler {

    @Override
    public boolean canHandle(LogLevel logLevel) {
        return logLevel == LogLevel.DEBUG;
    }
}
