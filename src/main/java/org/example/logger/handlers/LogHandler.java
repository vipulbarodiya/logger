package org.example.logger.handlers;

import lombok.Setter;
import org.example.logger.enums.LogLevel;
import org.example.logger.appenders.LogAppender;
import org.example.logger.models.LogMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LogHandler {
    @Setter
    private LogHandler next;

    private final List<LogAppender> observers = new CopyOnWriteArrayList<>();

    public abstract boolean canHandle(LogLevel logLevel);

    public void subscribe(LogAppender observer) {
        this.observers.add(observer);
    }

    public void notifyAll(LogMessage logMessage) {
        for(LogAppender appender: this.observers) {
            appender.append(logMessage);
        }
    }

    public void handleLog(LogMessage logMessage) {
        if(canHandle(logMessage.getLogLevel())) {
            notifyAll(logMessage);
        } else if(next!=null) {
            next.handleLog(logMessage);
        }
    }

}
