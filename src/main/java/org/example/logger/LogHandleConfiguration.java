package org.example.logger;

import org.example.logger.appenders.LogAppender;
import org.example.logger.enums.LogLevel;
import org.example.logger.handlers.*;

public class LogHandleConfiguration {

    LogHandler info = new InfoLogHandler();
    LogHandler debug = new DebugLogHandler();
    LogHandler warn = new WarnLogHandler();
    LogHandler error = new ErrorLogHandler();



    public LogHandler build() {
        info.setNext(debug);
        debug.setNext(warn);
        warn.setNext(error);
        return info;
    }

    public void appendAppendersForLogHandler(LogLevel logLevel, LogAppender appender) {
        switch(logLevel) {
            case INFO -> info.subscribe(appender);
            case WARN -> warn.subscribe(appender);
            case DEBUG -> debug.subscribe(appender);
            case ERROR -> error.subscribe(appender);
        }
    }

}

