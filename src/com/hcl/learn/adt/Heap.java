package com.hcl.learn.adt;

public class Heap
{
    static class Node
    {
        private int key;

        public Node(int key)
        {
            this.key = key;
        }


        public int getKey()
        {
            return key;
        }


        public void setKey(int key)
        {
            this.key = key;
        }

    }

    Node[] heapArray;
    int size, currentSize = -1;

    public Heap(int size)
    {
        this.size = size;
        heapArray = new Node[this.size];
    }


    public void insert(int key)
    {
        Node newNode = new Node(key);
        int currentPosition = ++currentSize;

        heapArray[currentPosition] = newNode;

        //after inserting check position
        while (((currentPosition - 1) / 2) > 0 && heapArray[((currentPosition - 1) / 2)].key > heapArray[currentPosition].key)
        {
            //swap prarent heapArray[newPosition].key with current node heapArray[currentPosition].key
            int tmp = heapArray[((currentPosition - 1) / 2)].key;
            heapArray[((currentPosition - 1) / 2)].key = heapArray[currentPosition].key;
            heapArray[currentPosition].key = tmp;

            //update current  currentPosition = ((currentPosition - 1) / 2);
            currentPosition = ((currentPosition - 1) / 2);
        }
    }


    public void print()
    {
        for (int i = 0; i < size / 2; i++) { 
            System.out.print(" PARENT : " + heapArray[i].key + " LEFT CHILD : " + 
                heapArray[2 * i].key + " RIGHT CHILD :" + heapArray[2 * i + 1].key); 
            System.out.println(); 
        } 
    }


    private void bfs(Node[] heapArray, int index)
    {
        if (index > size || heapArray[index] == null)
        {
            return;
        }

        System.out.println(heapArray[index].key);
        bfs(heapArray, (2 * index) + 1);
        bfs(heapArray, (2 * index) + 2);
    }


    public static void main(String[] args)
    {

        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(14);
        heap.insert(19);
        heap.insert(26);
        heap.insert(31);
        heap.insert(42);
        heap.insert(27);
        heap.insert(44);
        heap.insert(35);
        heap.insert(33);

        heap.print();
    }

}
