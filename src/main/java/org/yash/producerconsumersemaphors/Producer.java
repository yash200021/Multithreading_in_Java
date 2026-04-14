package org.yash.producerconsumersemaphors;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Queue<Object> objects;
    private String pro;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producer(Queue<Object> objects, String pro,
                    Semaphore producerSemaphore,
                    Semaphore consumerSemaphore){
        this.objects = objects;
        this.pro = pro;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                producerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            objects.add(new Object());
            System.out.println(this.pro + " has produced this object now.current size " + objects.size());
            consumerSemaphore.release();
        }
    }
}
