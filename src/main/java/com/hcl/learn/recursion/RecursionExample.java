package com.hcl.learn.recursion;

public class RecursionExample
{

    public int linearSearch(int[] arr, int index, int key)
    {
        if (index >= arr.length)
            return -1;
        else if (arr[index] == key)
            return index;
        else
            return linearSearch(arr, index + 1, key);
    }


    public int binarySearch(int[] arr, int min, int max, int key)
    {
        if (min > max)
            return -1;
        else
        {
            int mid = (min + max) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }
            else if (key > arr[mid])
            {
                return binarySearch(arr, mid + 1, max, key);
            }
            else
            {
                return binarySearch(arr, min, mid - 1, key);
            }
        }

    }


    public static void main(String[] args)
    {
        int[] a1 = {10, 20, 30, 50, 70, 90};
        int key = 90;

        System.out.println(key + " is found at index: " + new RecursionExample().binarySearch(a1, 0, a1.length - 1, key));

    }

}
