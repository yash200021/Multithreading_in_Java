package org.yash.producerconsumers;

import java.util.Queue;

public class Consumer implements Runnable {

    private Queue<Object> objects;
    private int maxSize;
    private String cons;

    public Consumer(Queue<Object> objects, int maxSize, String cons) {
        this.objects = objects;
        this.maxSize = maxSize;
        this.cons = cons;
    }

    @Override
    public void run() {
        while(true) {
            if(objects.size() > 0){
                objects.remove();
                System.out.println(this.cons + " is consuming. Current size " + objects.size());
            }
        }
    }
}
