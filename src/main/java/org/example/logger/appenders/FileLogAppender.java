package org.example.logger.appenders;

import lombok.SneakyThrows;
import org.example.logger.formatters.LogFormatter;
import org.example.logger.models.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogAppender implements LogAppender {
    LogFormatter formatter;
    BufferedWriter writer;
    String fileName;


    public  FileLogAppender(LogFormatter formatter,String fileName) {
        this.formatter = formatter;
        this.fileName = fileName;
        try {
            writer = new BufferedWriter(new FileWriter(fileName,true));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    @SneakyThrows
    @Override
    public void append(LogMessage logMessage) {
        String formatted  = this.formatter.format(logMessage);
        this.writer.write(formatted);
        this.writer.newLine();
        this.writer.flush();

    }
}
