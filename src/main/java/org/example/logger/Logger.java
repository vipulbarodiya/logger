package org.example.logger;

import lombok.Setter;
import org.example.logger.appenders.ConsoleLogAppender;
import org.example.logger.appenders.FileLogAppender;
import org.example.logger.enums.LogLevel;
import org.example.logger.formatters.TextLogFormatter;
import org.example.logger.handlers.LogHandler;
import org.example.logger.models.LogMessage;

import java.time.Instant;

public class Logger {

    private static class LoggerHolder{
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance(){
        return LoggerHolder.INSTANCE;
    }

    private Logger() {
        LogHandleConfiguration configuration = new LogHandleConfiguration();
        this.handlerChain = configuration.build();

        configuration.appendAppendersForLogHandler(LogLevel.INFO, new ConsoleLogAppender(new TextLogFormatter()));
        configuration.appendAppendersForLogHandler(LogLevel.DEBUG, new ConsoleLogAppender(new TextLogFormatter()));
        configuration.appendAppendersForLogHandler(LogLevel.WARN, new ConsoleLogAppender(new TextLogFormatter()));
        configuration.appendAppendersForLogHandler(LogLevel.ERROR, new ConsoleLogAppender(new TextLogFormatter()));
        configuration.appendAppendersForLogHandler(LogLevel.ERROR, new FileLogAppender(new TextLogFormatter(), "logs.txt"));

    }

    @Setter
    private LogHandler handlerChain;

    public void log(LogLevel level, String message){
        this.handlerChain.handleLog(new LogMessage(level, message, Instant.now().toEpochMilli()));
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }
    public void debug(String message){
        log(LogLevel.DEBUG, message);

    }
    public void info(String message){
        log(LogLevel.INFO, message);

    }
    public void warn(String message){
        log(LogLevel.WARN, message);
    }

}
