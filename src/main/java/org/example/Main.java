package org.example;

import org.example.logger.Logger;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.random.RandomGenerator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InterruptedException {
        // Test logger and it's functionality
        final Logger logger = Logger.getInstance();

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");


        // make two threads write log at the same time
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                logger.error("Thread 1: " + i);
            }
        });


        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                logger.error("Thread 2 :" + i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
