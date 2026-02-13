package org.example.logger.appenders;

import org.example.logger.formatters.LogFormatter;
import org.example.logger.models.LogMessage;

public class ConsoleLogAppender implements LogAppender {
    LogFormatter formatter;

    public ConsoleLogAppender(LogFormatter formatter) {
        this.formatter = formatter;
    }
    @Override
    public synchronized void append(LogMessage logMessage) {
        String formatted = this.formatter.format(logMessage);
        System.out.println(formatted);

    }
}
