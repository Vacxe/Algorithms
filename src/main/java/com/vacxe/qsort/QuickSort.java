package com.vacxe.qsort;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    Random random = ThreadLocalRandom.current();

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int l, int h) {
        if (h - l > 0) {
            int p = partition(arr, l, h);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, h);
        }
    }

    private int partitionRandom(int[] s, int l, int h) {
        int p = l + random.nextInt(h - l);
        int pivot = s[p];
        while (true) {
            while (s[l] < pivot) {
                l++;
            }
            while (s[h] > pivot) {
                h--;
            }
            if (l >= h) {
                return h;
            }
            swap(s, l, h);
        }
    }

    private int partition(int[] s, int l, int h) {
        int p = l + (h - l) / 2;
        int pivot = s[p];
        while (true) {
            while (s[l] < pivot) {
                l++;
            }
            while (s[h] > pivot) {
                h--;
            }
            if (l >= h) {
                return h;
            }
            swap(s, l, h);
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
