package org.yash.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {
    private final List<Integer> listToSort;
    private final ExecutorService executorService;

    public MergeSort(List<Integer> listToSort, ExecutorService executorService) {
        this.listToSort = listToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        System.out.println("Thread executing this task is :- " + Thread.currentThread().getName());
        if(listToSort.size() <= 1){
            return listToSort;
        }

        List<Integer> leftListToSort = new ArrayList<>();
        List<Integer> rightListToSort = new ArrayList<>();

        int mid = listToSort.size()/2;
        for(int i = 0;i < mid; i++) {
            leftListToSort.add(listToSort.get(i));
        }

        for(int i = mid; i < listToSort.size(); i++) {
            rightListToSort.add(listToSort.get(i));
        }

        Future<List<Integer>> leftList = executorService.submit(new MergeSort(leftListToSort, executorService));
        Future<List<Integer>> rightList = executorService.submit(new MergeSort(rightListToSort, executorService));
        
        List<Integer> leftSortedList = leftList.get();
        List<Integer> rightSortedList = rightList.get();

        return mergeList(leftSortedList, rightSortedList);
    }

    private List<Integer> mergeList(List<Integer> leftSortedList, List<Integer> rightSortedList) {
        List<Integer> finalList = new ArrayList<>();
        int i=0, j=0;
        while (i < leftSortedList.size() && j < rightSortedList.size()) {
            if(leftSortedList.get(i) <= rightSortedList.get(j)) {
                finalList.add(leftSortedList.get(i));
                i++;
            } else {
                finalList.add(rightSortedList.get(j));
                j++;
            }
        }

        while (i < leftSortedList.size()){
            finalList.add(leftSortedList.get(i));
            i++;
        }

        while (j < rightSortedList.size()) {
            finalList.add(rightSortedList.get(j));
            j++;
        }
        return finalList;
    }
}
