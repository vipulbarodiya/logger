package org.example.logger.appenders;

import org.example.logger.models.LogMessage;

public interface LogAppender {
    public void append(LogMessage logMessage);
}
