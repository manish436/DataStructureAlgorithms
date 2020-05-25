package com.hcl.learn.adt;

public class Hashtable
{
    String[] hashArray;
    int arraySize;
    int size = 0;

    public Hashtable(int noOfSlots)
    {
        if (isPrime(noOfSlots))
        {
            hashArray = new String[noOfSlots];
            arraySize = noOfSlots;
        }
        else
        {
            int primeCount = getNextPrimeNumber(noOfSlots);
            hashArray = new String[primeCount];
            arraySize = primeCount;

            System.out.println("Different hashtable size decied:" + primeCount);
        }

        hashArray = new String[noOfSlots];
    }


    private boolean isPrime(int noOfSlots)
    {
        for (int i = 2; i < noOfSlots / 2; i++)
        {
            if (noOfSlots % i == 0)
            {
                return false;
            }
        }

        return true;
    }


    private int getNextPrimeNumber(int startingNumber)
    {
        for (int i = startingNumber; true; i++)
        {
            if (isPrime(i))
            {
                return i;
            }
        }
    }


    //Find index number
    private int hashFunction(String word)
    {
        int hashVal = word.hashCode();
        hashVal %= arraySize;

        if (hashVal < 0)
        {
            hashVal += arraySize;
        }

        return hashVal;
    }


    //Find next step
    private int hashStepFunction(String word)
    {
        int hashVal = word.hashCode();
        hashVal %= arraySize;

        if (hashVal < 0)
        {
            hashVal += arraySize;
        }

        return 3 - hashVal % 3;
    }


    public void insert(String word)
    {
        int hashVal = hashFunction(word);
        int stepSize = hashStepFunction(word);

        while (hashArray[hashVal] != null)
        {
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }

        hashArray[hashVal] = word;
        System.out.println("Inserted word: " + word);
        size++;
    }


    public String find(String word)
    {
        int hashVal = hashFunction(word);
        int stepSize = hashStepFunction(word);

        while (hashArray[hashVal] != null)
        {
            if (hashArray[hashVal].equals(word))
            {
                return hashArray[hashVal];
            }
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }

        return hashArray[hashVal];
    }


    public static void main(String[] args)
    {
        Hashtable hashTable = new Hashtable(12);
        hashTable.insert("manish");
        hashTable.insert("paplu");
        hashTable.insert("siplu");
        hashTable.insert("gauri");

        System.out.println(hashTable.find("manish"));

    }

}
