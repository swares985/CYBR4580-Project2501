package com.twofivezeroone;

import java.util.List;
import java.util.LinkedList;

public class Main {

    public static int DEFAULT_SIZE = 1000000; // 1 MB

    public static void main(String[] args) {
        List<Byte[]> list = new LinkedList<Byte[]> ();
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
            list.add (new Byte[size]);
            try {
                Thread.sleep (2000);
            } catch (Exception ignored) {}
        }
    }

    private static void print(String data) {
        System.out.print("Log : " + data);
    }
}