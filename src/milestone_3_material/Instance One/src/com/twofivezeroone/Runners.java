package com.twofivezeroone;

import java.util.ArrayList;

public class Runners {

    private Runnable runOne;
    private CustomRunnableTask task;
    private Thread thread;

    private int runtimes = 0;

    public Runners(int runtimes) {
        this.runtimes = runtimes;
        this.task = new CustomTaskHandler();
    }

    public void startRunner() {
        runOne = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < ProjectConstants.MAX_READ_WRITE_TIMES; ++i) {
                    task.largeForLoop();
                    task.readAndWrite();
                }
            }
        };

        thread = new Thread(runOne);
        thread.start();
    }
}
