package com.hcl.learn.adt;

public class LinkedList<E>
{
    private static class Node<E>
    {
        E item;
        Node<E> next = null;

        @Override
        public String toString()
        {
            return "Node [item=" + item + "]";
        }
    }

    private Node<E> head = null;

    //    public void addFirst(E element)
    //    {
    //        Node<E> newNode = new Node<E>();
    //        newNode.item = element;
    //        newNode.next = head;
    //        head = newNode;
    //    }

    //    public void addLast(E element)
    //    {
    //        Node<E> currentNode = this.head;
    //        while (currentNode.next != null)
    //        {
    //            currentNode = currentNode.next;
    //        }
    //
    //        Node<E> newNode = new Node<E>();
    //        newNode.item = element;
    //
    //        currentNode.next = newNode;
    //    }

    public void viewElements()
    {
        Node<E> currentNode = this.head;
        while (currentNode != null)
        {
            System.out.println(currentNode);
            currentNode = currentNode.next;
        }
    }


    public void search(String key)
    {
        Node<E> current = this.head;
        int counter = 0;
        while (current != null)
        {
            if (current.item.equals(key))
                break;

            current = current.next;
            counter++;
        }

        if (current == null)
            System.out.println("Element not found");
        else
            System.out.println("Element found at: " + (counter + 1));
    }


    public void reverse()
    {
        Node<E> current = this.head;
        Node<E> previous = null;
        Node<E> next = null;

        while (current != null)
        {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        this.head = previous;
    }


    public void findSecondLast()
    {
        Node<E> current = this.head;
        while (current.next.next != null)
        {
            current = current.next;
        }

        System.out.println(current.item);

    }


    public void predecessor(String key)
    {
        Node<E> current = this.head;

        while (current.next != null)
        {
            if (current.next.item.equals(key))
                break;

            current = current.next;
        }

        if (current == null)
            System.out.println("Predecessor not found");
        else
            System.out.println("Predecessor found at: " + current.item);
    }


    public void getKthNode(int index)
    {
        Node<E> current = this.head;
        int i = 1;

        while (current != null)
        {
            if (i == index)
                break;

            current = current.next;
            i++;
        }

        if (current == null)
            System.out.println("Kth node not found");
        else
            System.out.println("Kth node found at: " + current.item);

    }


    public void addFirst(E element)
    {
        Node<E> newNode = new Node<>();
        newNode.item = element;

        if (this.head == null)
            this.head = newNode;
        else
        {
            newNode.next = head;
            this.head = newNode;
        }

    }


    public void addLast(E element)
    {
        Node<E> newNode = new Node<>();
        newNode.item = element;

        if (this.head == null)
            this.head = newNode;
        else
        {
            //trying to reach at the end.
            Node<E> current = this.head;
            while (current.next != null)
            {
                current = current.next;
            }

            //current is at the end.
            current.next = newNode;
        }

    }


    public void addAfterNode(E element, E afterElement)
    {
        Node<E> newNode = new Node<>();
        newNode.item = element;

        Node<E> current = this.head;

        while (current != null)
        {
            if (current.item.equals(afterElement))
                break;

            current = current.next;
        }

        if (current == null)
            System.out.println("Kth node not found");
        else
        {
            newNode.next = current.next;

            current.next = newNode;

        }
    }


    public void addAfterBefore(E element, E beforeElement)
    {
        Node<E> newNode = new Node<>();
        newNode.item = element;

        Node<E> current = this.head;

        while (current.next != null)
        {
            if (current.next.item.equals(beforeElement))
                break;

            current = current.next;
        }

        if (current == null)
            System.out.println("Kth node not found");
        else
        {

            newNode.next = current.next;

            current.next = newNode;

        }
    }


    public void deleteFirstNode()
    {
        this.head = this.head.next;
    }


    public void deleteNode(E elementToDelete)
    {
        Node<E> current = this.head;
        while (current.next != null)
        {
            if (current.next.item.equals(elementToDelete))
                break;

            current = current.next;
        }

        //we found predecessor
        current.next = current.next.next;
    }


    public void deleteLastNode()
    {
        Node<E> current = this.head;
        while (current.next.next != null)
        {
            current = current.next;
        }

        current.next = null;
    }


    public void sorting()
    {
        Node<E> end, fast, slow;

        for (end = null; end != this.head.next; end = fast)
        {
            for (fast = this.head; fast.next != end; fast = fast.next)
            {
                slow = fast.next;
                if (fast.item.toString().compareToIgnoreCase(slow.item.toString()) > 0)
                {
                    String temp = fast.item.toString();
                    fast.item = slow.item;
                    slow.item = (E) temp;
                }
            }
        }
    }


    public void merge(LinkedList first, LinkedList second)
    {

    }


    public static void main(String[] args)
    {
        LinkedList<String> ll = new LinkedList<>();
        ll.addFirst("Appu");
        ll.addFirst("aradhika");
        ll.addFirst("Chapp");
        ll.addFirst("Dabbu");
        ll.addLast("NewLappu");
        ll.addLast("great new NewLappu");

        ll.addAfterNode("Singru", "Dabbu");

        ll.addAfterBefore("Lablu", "NewLappu");

        //ll.reverse();
        System.out.println("===========");
        // ll.search("aradhika");
        //System.out.println("===========");
        // ll.findSecondLast();

        //ll.predecessor("aradhika");

        // ll.getKthNode(1);

        ll.viewElements();
        ll.sorting();
        System.out.println("===========");
        ll.viewElements();

    }

}
