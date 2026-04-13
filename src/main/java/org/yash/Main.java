package org.yash;

import org.yash.mergesort.MergeSort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Integer> listToSort = List.of(96,67,5,4,8,10,22);

        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSort ms = new MergeSort(listToSort, executorService);

        Future<List<Integer>> result = executorService.submit(ms);
        System.out.println(result.get());

        executorService.shutdown();

    }
}