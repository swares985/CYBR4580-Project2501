package com.twofivezeroone;

import java.util.ArrayList;

public class RipClass {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("We ded");
        Main.list = new ArrayList<>();
    }
}
