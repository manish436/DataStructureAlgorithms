package com.hcl.learn.adt;

import javax.swing.tree.TreeNode;

public class BinarySearchTree
{
    static class Node
    {
        int data;
        Node left;
        Node right;

        @Override
        public String toString()
        {
            return "Node [data=" + data + "]";
        }
    }

    Node root;

    public void insert(int element)
    {
        Node newNode = new Node();
        newNode.data = element;

        if (root == null)
        {
            root = newNode;
        }
        else
        {
            Node current = root;
            while (true)
            {
                Node parent = current;
                if (element < current.data)
                {
                    current = current.left;
                    if (current == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                }
                else
                {
                    current = current.right;
                    if (current == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }


    public void search(int element)
    {

        if (root.data == element)
        {
            System.out.println("found at root");
            return;
        }
        else
        {
            int i = 0;
            Node current = root;
            while (current != null)
            {
                if (element < current.data)
                {
                    current = current.left;
                }
                else if (element > current.data)
                {
                    current = current.right;
                }
                else
                {
                    System.out.println("element found");
                }
                i++;
            }
        }
    }


    public void print()
    {
        this.traverse(this.root);
    }


    private void traverse(Node node)
    {
        if (node == null)
            return;

        traverse(node.left);
        System.out.println(node.data);
        traverse(node.right);
    }


    public Node smallest()
    {
        Node smallest = null;
        Node current = root;
        while (current != null)
        {
            smallest = current;
            current = current.left;
        }

        return smallest;
    }


    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(91);
        bst.insert(15);
        bst.insert(21);
        bst.insert(72);

        bst.print();

        bst.search(100);

        //        Node smallest = bst.smallest();
        //        System.out.println("Smallest:" + smallest);

        System.out.println("====================");
        java.util.LinkedList<TreeNode> stack = new java.util.LinkedList();
        System.out.println(!stack.isEmpty());

        while (!stack.isEmpty())
        {
            System.out.println("hi");
        }
    }


    public static boolean helperOld(Integer lower, Integer upper)
    {
        int val = 5;
        if (lower != null && val <= lower)
        {
            System.out.println("null !=null");
        }

        if (upper != null && val >= upper)
            return false;

        return true;
    }


    public boolean helper(Node node, Integer lower, Integer upper)
    {
        if (node == null)
            return true;

        int val = node.data;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        if (!helper(node.right, val, upper))
            return false;
        if (!helper(node.left, lower, val))
            return false;
        return true;
    }


    public boolean isValidBST(Node root)
    {
        return helper(root, null, null);
    }
}
