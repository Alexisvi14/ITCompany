package com.solvd.threads;

import static com.solvd.staff.Employee.LOGGER;

public class Dev extends Thread {
    @Override
    public synchronized void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("this is the run called from the Dev Class");
    }
}
