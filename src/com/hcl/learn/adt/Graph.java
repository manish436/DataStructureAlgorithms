package com.hcl.learn.adt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph
{
    List<Vertix> vertices;
    Map<Integer, ArrayList<Integer>> adjList;
    int vertixSize = 0;
    int edgesSize = 0;

    Stack<Integer> stack;

    public static class Vertix
    {
        char label;
        boolean isVisited = false;

        public Vertix(char label)
        {
            this.label = label;
        }

    }

    public Graph()
    {
        vertices = new ArrayList<>();
        adjList = new HashMap<Integer, ArrayList<Integer>>();
        stack = new Stack<>();
    }


    public void addVertix(char label)
    {
        vertices.add(new Vertix(label));
    }


    public void addEdge(int vertix, int edge)
    {
        List<Integer> vertixRef = null;
        if (adjList.containsKey(vertix))
        {
            vertixRef = adjList.get(vertix);
            vertixRef.add(edge);
        }
        else
        {
            vertixRef = new ArrayList<Integer>();
            vertixRef.add(edge);
            adjList.put(vertix, (ArrayList<Integer>) vertixRef);
        }
        edgesSize++;
    }


    public void getEdge(int vertix)
    {

        if (adjList.containsKey(vertix))
        {
            List<Integer> vertixRef = adjList.get(vertix);
            for (Integer vertixRefEach : vertixRef)
            {
                System.out.println(vertix + "-->" + vertixRefEach);
            }
        }
        else
        {
            System.out.println("Vertix not found");
        }

    }


    private void printVertix(int index)
    {
        System.out.println(this.vertices.get(index).label);
    }


    public void dfs()
    {
        //        for (int i = 0; i < adjList.size(); i++)
        //        {
        //            if (vertices.get(i).isVisited == false)
        //                dfcUtil(i);
        //        }

        Stack<Integer> stack = new Stack<>();

        printVertix(0);
        vertices.get(0).isVisited = true;
        stack.push(0);

        while (!stack.isEmpty())
        {
            if (adjList.get(stack.peek()) == null)
            {
                stack.pop();
            }
            else
            {
                List<Integer> newVertixList = adjList.get(stack.peek());
                for (Integer eachVertix : newVertixList)
                {
                    if (!vertices.get(eachVertix).isVisited)
                    {
                        printVertix(eachVertix);
                        vertices.get(eachVertix).isVisited = true;
                        stack.push(eachVertix);
                        break;
                    }
                }
            }

        }
    }


    private void dfcUtil(int index)
    {
        vertices.get(index).isVisited = true;
        printVertix(index);
        if (adjList.get(index) != null)
        {
            List<Integer> newVertixList = adjList.get(index);
            for (Integer eachVertix : newVertixList)
            {
                if (vertices.get(eachVertix).isVisited == false)
                {
                    dfcUtil(eachVertix);
                }
            }
        }
    }


    public void bfs()
    {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(0);

        while (!queue.isEmpty())
        {
            int v = queue.remove();
            printVertix(v);

            if (null != adjList.get(v))
            {
                List<Integer> newVertix = adjList.get(v);
                for (Integer eachVertix : newVertix)
                {
                    if (vertices.get(eachVertix).isVisited == false)
                    {
                        vertices.get(eachVertix).isVisited = true;
                        queue.add(eachVertix);
                    }
                }
            }

        }
    }


    public static void main(String[] args)
    {

        Graph graph = new Graph();

        graph.addVertix('A');
        graph.addVertix('B');
        graph.addVertix('C');
        graph.addVertix('D');
        graph.addVertix('E');
        graph.addVertix('F');

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println("============");
        graph.dfs();
        //        System.out.println();
        //        System.out.println("============");
        //        graph.bfs();

    }

}
