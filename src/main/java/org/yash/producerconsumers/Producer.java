package org.yash.producerconsumers;

import java.util.Queue;

public class Producer implements Runnable {
    private Queue<Object> objects;
    private int maxSize;
    private String pro;

    public Producer(Queue<Object> objects, int maxSize, String pro){
        this.objects = objects;
        this.maxSize = maxSize;
        this.pro = pro;
    }

    @Override
    public void run() {
        while (true) {
            if(objects.size() < maxSize) {
                objects.add(new Object());
                System.out.println(this.pro + " is producing. Current size :" + objects.size());
            }
        }
    }
}
