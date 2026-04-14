package org.yash.producerconsumers;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        Queue<Object> objects = new ConcurrentLinkedQueue<>();
        int maxSize = 6;

        Producer p1 = new Producer(objects, maxSize, "P1");
        Producer p2 = new Producer(objects, maxSize, "P2");
        Producer p3 = new Producer(objects, maxSize, "P3");
        Producer p4 = new Producer(objects, maxSize, "P4");
        Producer p5 = new Producer(objects, maxSize, "P5");
        Producer p6 = new Producer(objects, maxSize, "P6");

        Consumer c1 = new Consumer(objects, maxSize, "C1");
        Consumer c2 = new Consumer(objects, maxSize, "C2");
        Consumer c3 = new Consumer(objects, maxSize, "C3");
        Consumer c4 = new Consumer(objects, maxSize, "C4");
        Consumer c5 = new Consumer(objects, maxSize, "C5");

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
