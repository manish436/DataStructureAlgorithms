package com.hcl.learn.sorting;

import java.util.Arrays;

public class SortingAlgorithm
{
    public void selectionSort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[min] > arr[j])
                    min = j;
            }

            int swap = arr[i];
            arr[i] = arr[min];
            arr[min] = swap;
        }
    }


    public void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

    }


    public void mergeSort(int[] arr, int l, int r)
    {
        if (l < r)
        {
            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }

    }


    private void merge(int[] arr, int l, int m, int r)
    {
        //find length of new arrays
        int leftSize = m - l + 1;
        int rightSize = r - m;

        //create new arrays, left and right with the above size
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];

        // initialize both the arrays with l and r range
        for (int i = 0; i < leftSize; i++)
        {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < rightSize; j++)
        {
            R[j] = arr[m + 1 + j];
        }

        int k = l;
        int i = 0, j = 0;
        //loop trough both the arrays and putting in Original array
        while (i < leftSize && j < rightSize)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //check and put remaining elements of both arrays
        while (i < leftSize)
        {
            arr[k++] = L[i++];
        }
        while (j < rightSize)
        {
            arr[k++] = R[j++];
        }

    }


    public void quickSort(int[] arr, int l, int r)
    {
        if (l < r)
        {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }


    private int partition(int[] arr, int l, int r)
    {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;

            }
        }

        int swap = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = swap;

        pivot = i + 1;

        return pivot;
    }


    public static void main(String[] args)
    {
        int[] arr = {47, 3, 25, 19, 8, 18};

        SortingAlgorithm sortAlog = new SortingAlgorithm();
        sortAlog.quickSort(arr, 0, arr.length - 1);

        printArrays(arr);
    }


    private static void printArrays(int[] arr)
    {
        System.out.println("Sorted array:" + Arrays.toString(arr));
    }

}
