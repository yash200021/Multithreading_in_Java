package org.yash.producerconsumersemaphors;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Object> objects = new ConcurrentLinkedQueue<>();
        int maxSize = 6;

        Semaphore producerSemaphore = new Semaphore(maxSize);
        Semaphore consumerSemaphore = new Semaphore(0);


        Producer p1 = new Producer(objects, "P1", producerSemaphore, consumerSemaphore);
        Producer p2 = new Producer(objects, "P2", producerSemaphore, consumerSemaphore);
        Producer p3 = new Producer(objects, "P3", producerSemaphore, consumerSemaphore);
        Producer p4 = new Producer(objects, "P4", producerSemaphore, consumerSemaphore);
        Producer p5 = new Producer(objects, "P5", producerSemaphore, consumerSemaphore);
        Producer p6 = new Producer(objects, "P6", producerSemaphore, consumerSemaphore);

        Consumer c1 = new Consumer(objects, "C1", producerSemaphore, consumerSemaphore);
        Consumer c2 = new Consumer(objects, "C2", producerSemaphore, consumerSemaphore);
        Consumer c3 = new Consumer(objects, "C3", producerSemaphore, consumerSemaphore);
        Consumer c4 = new Consumer(objects, "C4", producerSemaphore, consumerSemaphore);
        Consumer c5 = new Consumer(objects, "C5", producerSemaphore, consumerSemaphore);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(p3);
        executorService.submit(p4);
        executorService.submit(p5);
        executorService.submit(p6);
        executorService.submit(c1);
        executorService.submit(c2);
        executorService.submit(c3);
        executorService.submit(c4);
        executorService.submit(c5);
    }
}
