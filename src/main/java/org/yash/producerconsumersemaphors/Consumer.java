package org.yash.producerconsumersemaphors;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {

    private Queue<Object> objects;
    private String cons;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(Queue<Object> objects, String cons,
                    Semaphore producerSemaphore,
                    Semaphore consumerSemaphore) {
        this.objects = objects;
        this.cons = cons;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            try {
                consumerSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            objects.remove();
            System.out.println(this.cons + " has produced this object now.current size " + objects.size());
            producerSemaphore.release();
        }
    }
}
