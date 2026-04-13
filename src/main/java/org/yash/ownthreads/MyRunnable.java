package org.yash.ownthreads;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("This is getting executed by my own thread " +
                Thread.currentThread().getName());
    }
}
