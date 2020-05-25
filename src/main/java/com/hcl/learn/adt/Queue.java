package com.hcl.learn.adt;

public class Queue<E>
{
    private Object[] queue;
    private int size = 0;
    private int maxSize = 0;
    private int front = 0;
    private int rear = 0;

    public Queue(int maxSize)
    {
        this.maxSize = maxSize;
        this.queue = new Object[this.maxSize];
    }


    public void equeue(E element)
    {
        if (this.isFull())
        {
            System.out.println("Queue is full!");
            return;
            /*
             * for circular queue
             * reset rear to first position so that it replaces beaning element again
             * "As everything stats from zero and ends to zero"
             *  rear = 0;
             */
        }

        this.queue[rear++] = element;
        this.size++;
    }


    public E dequeue()
    {
        if (this.isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
            /*
             * for circular queue
             * reset front to first position so that it start deleting beaning element again
             * "As everything stats from zero and ends to zero"
             *  front = 0;
             */
        }

        this.size--;
        return (E) this.queue[front++];
    }


    public boolean isFull()
    {
        return (this.maxSize == this.size);
    }


    public boolean isEmpty()
    {
        return (this.size == 0);
    }


    public static void main(String[] args)
    {
        Queue<Integer> myqueue = new Queue<>(5);
        myqueue.equeue(1);
        myqueue.equeue(2);
        myqueue.equeue(3);
        myqueue.equeue(4);
        myqueue.equeue(5);

        while (!myqueue.isEmpty())
        {
            System.out.println(myqueue.dequeue());
        }

    }

}
