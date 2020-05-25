package com.hcl.learn.problems.strings;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Use Following functions
 * 1. string.length()
 * 2. string.substr()
 * 3. string.charAr()
 * 4. string.indexOf()
 * 5. string.lastIndexOf()
 * 
 */
public class StringProblems
{
    /**
    Given a string of odd length, return the middle 3 characters from the string, 
    so the string <b>"Monitor"</b> yields <b>"nit"</b>. 
    If the string length is less than 3, return the string as is. <br> <br>
    
    <b>EXPECTATIONS:</b><br>
    middleThree("bunny") <b>---></b> "unn" <br>
    middleThree("peter") <b>---></b> "ete" <br>
    middleThree("Jamaica") <b>---></b>"mai" <br>
     */
    public static String middleThree(String str)
    {
        if (str.length() < 3)
            return str;

        String result = null;
        int startingPoint = (str.length() / 2) - 1;
        int endingPoint = (str.length() / 2) + 2;
        result = str.substring(startingPoint, endingPoint);

        return result;
    }


    public static int firstUniqChar(String s)
    {
        int result = -1;
        Map<Character, Integer> charOccurence = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (charOccurence.containsKey(c))
            {
                charOccurence.put(c, charOccurence.get(c) + 1);
            }
            else
            {
                charOccurence.put(c, 1);
            }
        }

        Iterator<Entry<Character, Integer>> itr = charOccurence.entrySet().iterator();
        while (itr.hasNext())
        {
            Entry<Character, Integer> object = itr.next();
            if (object.getValue() == 1)
            {
                result = s.indexOf(object.getKey());
                break;
            }
        }
        return result;
    }


    public static boolean isAnagram(String s, String t)
    {
        boolean status = true;

        if (s.length() != t.length())
            return false;

        char[] firstStringArray = s.toCharArray();
        char[] secondStringArray = t.toCharArray();
        Arrays.sort(firstStringArray);
        Arrays.sort(secondStringArray);

        for (int i = 0; i < firstStringArray.length; i++)
        {
            if (firstStringArray[i] != secondStringArray[i])
            {
                status = false;
                break;
            }
        }

        return status;
    }


    public static void main(String[] args)
    {
        String s = "abcd", t = "dabc";
        System.out.println(isAnagram(s, t));

        //        String s = "leetcode";
        //        System.out.println(firstUniqChar(s));

    }

}
