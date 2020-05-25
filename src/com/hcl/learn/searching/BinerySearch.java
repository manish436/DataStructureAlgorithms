package com.hcl.learn.searching;

public class BinerySearch
{
    public int binerySearch(int[] arr, int element)
    {
        int min = 0;
        int max = arr.length - 1;

        int mid = (min + max) / 2;

        while (min <= max)
        {
            if (arr[mid] == element)
            {

                return mid;
            }
            else if (element > arr[mid])
            {

                min = mid + 1;
            }
            else
            {

                max = mid - 1;
            }
            mid = (min + max) / 2;
        }

        return 0;
    }


    public static void main(String[] args)
    {
        int[] a1 = {10, 20, 30, 50, 70, 90, 100};
        int key = 30;
        System.out.println(key + " is found at index: " + new BinerySearch().binerySearch(a1, key));
    }

}
