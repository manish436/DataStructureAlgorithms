package com.hcl.learn.adt;

public class CircularLinkedList<E>
{
    static class Node<E>
    {
        Object item;
        Node next;

        public Node(E element)
        {
            this.item = element;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    public void insert(E element)
    {
        Node<E> newNode = new Node<>(element);
        if (this.isEmpty())
        {
            this.head = newNode;
        }
        else
        {
            this.tail.next = newNode;
        }

        this.tail = newNode;
        newNode.next = this.head;
    }


    public void printAll()
    {
        Node<E> currentNode = this.head;
        do
        {
            System.out.println(currentNode.item);
            currentNode = currentNode.next;
        }
        while (currentNode != this.head);
    }


    private boolean isEmpty()
    {
        return (this.head == null);
    }


    public static void main(String[] args)
    {
        CircularLinkedList<Integer> myCll = new CircularLinkedList<>();
        myCll.insert(5);
        myCll.insert(4);
        myCll.insert(3);
        myCll.insert(2);
        myCll.insert(1);

        myCll.printAll();

    }

}
