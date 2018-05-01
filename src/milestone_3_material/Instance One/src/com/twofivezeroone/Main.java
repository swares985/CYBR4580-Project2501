package com.twofivezeroone;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.twofivezeroone.ProjectConstants.MEGABYTE;

public class Main {

    public static int DEFAULT_SIZE = 1000000; // 1 MB

    public static List<byte[]> list = new LinkedList<>();

    public static void main(String[] args) {

        // custom
        String theOnlyName = "Carpet".intern();
        RipClass ripClass = new RipClass();


        routineCheckStart();

        Runners r = new Runners(1);
        r.startRunner();


        int counter = 0;

        String sizeStr = System.getenv("MEM_SIZE");

        print("Size : " + sizeStr);

        int size;

        if (sizeStr == null || "".equals(sizeStr)) {
            size = DEFAULT_SIZE;
        } else {
            size = Integer.parseInt (sizeStr);
        }

        print("Allocating" + size);

        while (true) {
            counter++;
            print("Counter" + counter);
            try {
                list.add (new byte[size]);
                Thread.sleep (1);
            } catch (OutOfMemoryError e) {
                //theOnlyName = null;
                ripClass = null;
                System.gc();
                print("In the exception");
            } catch (InterruptedException e) {
                print("Interrupted");
            }

            /*if (counter % 50 == 0) {
                System.gc();
            }*/
            if (counter % 500 == 0) {
                print("Breakpoint");
            }
        }
    }

    private static void routineCheckStart() {
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                print("Inside routine check");

                MemoryUsage heapUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
                long maxMemory = heapUsage.getMax() / MEGABYTE;
                long usedMemory = heapUsage.getUsed() / MEGABYTE;
                System.out.println(" : Memory Use :" + usedMemory + "M/" + maxMemory + "M");
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    private static void print(String data) {
        System.out.println("Log : " + data);
    }
}