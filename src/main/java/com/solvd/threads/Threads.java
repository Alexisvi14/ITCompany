package com.solvd.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Threads {
    private static final Logger LOGGER = LogManager.getLogger(Threads.class);

    public static void main(String[] args) {

        Dev d = new Dev();
        Dev d1 = new Dev();
        Dev d2 = new Dev();
        Dev d3 = new Dev();
        Dev1 d5 = new Dev1();
        Dev1 d6 = new Dev1();
        Dev1 d7 = new Dev1();

        ThreadPoolExecutor tp = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        Conection dbConection = new Conection("Info of the data base");
        tp.execute(d);
        tp.execute(d1);
        tp.execute(d2);
        tp.execute(d3);
        tp.execute(d5);
        tp.execute(d6);
        tp.execute(d7);
        tp.shutdown();
    }
}
