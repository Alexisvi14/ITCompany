package com.solvd.threads;

import static com.solvd.staff.Employee.LOGGER;

public class Dev1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("This is the run method from the Dev1 Class");
    }
}
