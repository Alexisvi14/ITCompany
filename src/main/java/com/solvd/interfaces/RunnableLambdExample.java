package com.solvd.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ThreadDemo implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(ThreadDemo.class);

    @Override
    public void run() {
        LOGGER.info("The run method is called...");
    }
}
public class
RunnableLambdExample {
    private static final Logger LOGGER = LogManager.getLogger(RunnableLambdExample.class);

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadDemo());
        thread.start();

        Runnable runnable = () -> LOGGER.info("Run method using Lambda...from the thread");

        Thread threadLambda = new Thread(runnable);
        threadLambda.start();

    }
}
