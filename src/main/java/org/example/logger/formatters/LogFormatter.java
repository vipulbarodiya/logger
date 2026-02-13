package org.example.logger.formatters;

import org.example.logger.models.LogMessage;

public interface LogFormatter {

    public String format(LogMessage logMessage);
}
