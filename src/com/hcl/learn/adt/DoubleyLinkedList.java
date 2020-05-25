package com.hcl.learn.adt;

public class DoubleyLinkedList<E>
{
    static class Node<E>
    {
        Node<E> previous;
        E item;
        
        Node<E> next;

        public Node(E element)
        {
            this.item = element;
        }


        @Override
        public String toString()
        {
            return "Node [item=" + item + "]";
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public void insert(E element)
    {
        Node<E> newNode = new Node<>(element);
        if (this.empty())
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else
        {
            newNode.previous = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }


    public void insertAfter(E key, E element)
    {
        Node<E> newNode = new Node<>(element);

        //first search element
        Node<E> afterNode = this.searchElement(key);

        if (afterNode.next == null)
            this.tail = newNode;
        else
            afterNode.next.previous = newNode;

        newNode.next = afterNode.next;
        afterNode.next = newNode;
        newNode.previous = afterNode;
    }


    public Node<E> searchElement(E element)
    {
        Node<E> currentNode = this.head;
        while (currentNode.item != element)
        {
            if (currentNode.next == null)
                return null;
            currentNode = currentNode.next;
        }

        return currentNode;
    }


    public void printForward()
    {
        Node<E> currentNode = this.head;
        while (currentNode != null)
        {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }


    public void printBackward()
    {
        Node<E> currentNode = this.tail;
        while (currentNode != null)
        {
            System.out.println(currentNode);
            currentNode = currentNode.previous;
        }
    }


    private boolean empty()
    {
        return (this.head == null);
    }


    public static void main(String[] args)
    {
        DoubleyLinkedList<Integer> dLL = new DoubleyLinkedList<>();
        dLL.insert(5);
        dLL.insert(4);
        dLL.insert(3);
        dLL.insert(2);
        dLL.insert(1);

        dLL.insertAfter(4, 99);

        dLL.printForward();
    }

}
