package com.hcl.learn.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Problems
{
    private static Map<Character, Integer> coutingDuplicateChar(String str)
    {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++)
        {
            BiFunction<Character, Integer, Integer> funcPutValuesInHashMap = (K, V) -> (V == null) ? 1 : ++V;

            count.compute(str.charAt(i), funcPutValuesInHashMap);

        }

        return count;
    }


    private Map<Character, Long> coutingDuplicateCharStream(String str)
    {
        Map<Character, Long> count =
            str
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return count;
    }


    private static String reverseWords(String name)
    {
        StringBuilder newName = new StringBuilder(name);
        //        for (int i = name.length() - 1; i >= 0; i--)
        //        {
        //            //System.out.println(name.charAt(i));
        //            newName.append(name.charAt(i));
        //        }

        //return newName.toString();
        return newName.reverse().toString();
    }


    public static int[] intersectOld(int[] nums1, int[] nums2)
    {

        List<Integer> secondList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++)
        {
            secondList.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++)
        {
            if (secondList.contains(nums1[i]))
            {
                resultList.add(nums1[i]);
            }
        }

        return resultList
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }


    private static boolean containsOnlyDigits(String name)
    {

        //        for (int i = 0; i < name.length(); i++)
        //        {
        //            if (!Character.isDigit(name.charAt(i)))
        //            {
        //                return false;
        //            }
        //        }
        //        return true;

        return name.chars().anyMatch(c -> Character.isDigit(c));
    }


    public static int[] intersect(int[] nums1, int[] nums2)
    {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length)
        {
            if (nums1[p1] < nums2[p2])
            {
                p1++;
            }
            else if (nums1[p1] > nums2[p2])
            {
                p2++;
            }
            else
            {
                //both equal
                result.add(nums1[p1]);
                p1++;
                p2++;
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


    public static int[] intersect2(int[] nums1, int[] nums2)
    {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++)
        {
            System.out.println(check(nums2, nums1[i]));

            if (check(nums2, nums1[i]))
            {
                result.add(nums1[i]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


    public static void rotate(int[] nums, int k)
    {
        for (int i = 0; i < k; i++)
        {
            int existElement = nums[nums.length - 1];
            int shiftCounter = nums.length - 2;

            //shifting all elements to right
            while (shiftCounter >= 0)
            {
                nums[shiftCounter + 1] = nums[shiftCounter];
                shiftCounter--;
            }
            nums[0] = existElement;
        }

    }


    public static int[] intersectStream(int[] nums1, int[] nums2)
    {

        List<Integer> secondList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++)
        {
            secondList.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++)
        {
            if (secondList.contains(nums1[i]))
            {
                resultList.add(nums1[i]);
            }
        }

        return resultList
            .stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }


    private static boolean check(int[] arr, int toCheckValue)
    {

        for (int element : arr)
        {
            if (element == toCheckValue)
            {
                return true;
            }
        }

        return false;
    }


    public static int[] plusOne(int[] digits)
    {
        Long digit = 0L;
        for (int i : digits)
        {
            digit = digit * 10;
            digit += i;
        }
        System.out.println(digit);

        return Long.toString(digit + 1).chars().map(c -> c - '0').toArray();
    }


    public static void reverseString(char[] s)
    {
        System.out.println(s.length);
        int mid = (s.length / 2);

        int p1 = 0, p2 = s.length - 1;
        while (p1 <= mid && p2 >= mid)
        {
            char tmp = s[p1];
            s[p1] = s[p2];
            s[p2] = tmp;
            p1++;
            p2--;
        }
    }


    public static int reverse(int x)
    {
        boolean isNegative = x < 0 ? true : false;

        if (isNegative)
            x = x * -1;

        long sum = 0;
        while (x > 0)
        {
            int rem = x % 10;
            sum = (sum * 10) + rem;
            x = x / 10;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
            {
                return 0;
            }
        }

        if (isNegative)
            sum = sum * -1;

        return (int) sum;
    }


    public static void print(int i)
    {
        System.out.println(i);
    }


    public static int findFirstOccurrence(int[] A, int x)
    {
        int result = -1;
        int left = 0;
        int right = A.length - 1;
        int mid;

        while (left <= right)
        {
            mid = (left + right)/2;
            if (A[mid] == x)
            {
                result = mid;
                right = mid - 1;
            }

            if (A[mid] < x)
            {
                //go to right part
                left = mid + 1;
            }
            else if (A[mid] > x)
            {
                right = mid - 1;
            }
        }

        //brute force approach
//        for (int i = 0; i < A.length; i++)
//        {
//            if (A[i] == x)
//            {
//                result = i;
//                break;
//            }
//
//        }

        return result;
    }


    public static int findLastOccurrence(int[] A, int x)
    {
        int result = -1;
        int left = 0;
        int right = A.length - 1;
        int mid;

        while (left <= right)
        {
            mid = (left + right)/2;
            if (A[mid] == x)
            {
                result = mid;
                left = mid + 1;
            }

            if (A[mid] < x)
            {
                //go to right part
                left = mid + 1;
            }
            else if (A[mid] > x)
            {
                right = mid - 1;
            }
        }

        //brute force approach
//        for (int i = A.length-1; i >= 0; i--)
//        {
//            if (A[i] == x)
//            {
//                result = i;
//                break;
//            }
//
//        }

        return result;
    }


    public static void main(String[] args)
    {

        List<Integer> myList = List.of(1, 2, 2);

        //myList.stream().forEach(obj::print);

        //System.out.println(reverse(1534236469));
        //        String one = "hello";
        //        String two = "hello";
        //        System.out.println(one.equals(two));
        //
        //        one = one + "hihi";
        //        System.out.println(one == two);

        //        CustomerRecords records = new CustomerRecords();
        //
        //        records.addCustomer(new Customer("John"));
        //        records.addCustomer(new Customer("Simon"));
        //
        //        Map<String, Customer>  res = records.getCustomers();
        //        for (Customer next : res.values())
        //        {
        //            next = new Customer("panpi");
        //            System.out.println(next);
        //        }
        //
        //        for (Customer next : records.getCustomers().values())
        //        {
        //            System.out.println(next);
        //        }

        //        char[] nums1 = {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'};
        //        reverseString(nums1);
        //        System.out.println(nums1);

        //        int[] nums1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        //
        //        plusOne(nums1);
        //
        //        //        int[] nums1 = {1, 2, 2, 1};
        //        //        int[] nums2 = {2};
        //        int[] result = plusOne(nums1);
        //        //
        //        System.out.println(Arrays.toString(result));

        //        Map<Character, Integer> count = coutingDuplicateChar("Aaradhika");
        //        Set<Map.Entry<Character, Integer>> entrySet = count.entrySet();
        //
        //        for (Entry<Character, Integer> entrySetEach : count.entrySet())
        //        {
        //            System.out.println("Key:" + entrySetEach.getKey() + ";  Value:" + entrySetEach.getValue());
        //        }

        //System.out.println(containsOnlyDigits("Aaradhika"));
        //System.out.println(containsOnlyDigits("23131223123"));

        //        Problems main = new Problems();
        //        main.start();

        int[] A = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int key = 5;

        int index = findLastOccurrence(A, key);

        if (index != -1)
        {
            System.out
                .println(
                    "First occurrence of element "
                        + key +
                        " is found at index " + index);
        }
        else
        {
            System.out.println("Element not found in the array");
        }

    }

}
