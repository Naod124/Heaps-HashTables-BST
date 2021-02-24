package com.company;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Time {
    private long start;
    private long stop;

    private final NumberFormat formatter = new DecimalFormat("#0.000000000");

    public void startTimer(){
        start = System.nanoTime();
    }

    public void stopTimer(){
        stop = System.nanoTime();
    }

    public String toString(long time){
        return formatter.format(time/1000000000d);
    }
    public long getTime(){
        return stop - start;
    }
}
