package com.hcl.learn.searching;

public class LinearSearch
{
    public <E> int linearSearch(E[] arr, E element)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == element)
                return (int) i;
        }
        return -1;
    }


    public static void main(String[] args)
    {
        Integer[] a1 = {10, 20, 30, 50, 70, 90};
        int key = 50;

        System.out.println(key + " is found at index: " + new LinearSearch().linearSearch(a1, key));

    }

}
