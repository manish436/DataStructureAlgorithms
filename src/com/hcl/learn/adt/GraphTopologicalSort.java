package com.hcl.learn.adt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class GraphTopologicalSort
{
    Map<Integer, ArrayList<Integer>> graph;
    boolean visited[];
    boolean beingVisited[];
    int size;

    public GraphTopologicalSort(int size)
    {
        this.size = size;
        graph = new HashMap<Integer, ArrayList<Integer>>();
        visited = new boolean[this.size];
        beingVisited = new boolean[this.size];
    }


    public void addEdge(int source, int dest)
    {
        if (this.graph.containsKey(source))
        {
            this.graph.get(source).add(dest);
        }
        else
        {
            ArrayList<Integer> internalVertix = new ArrayList<>();
            internalVertix.add(dest);
            this.graph.put(source, internalVertix);
        }

    }


    public void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < this.size; i++)
        {
            if (visited[i] == false)
                dfs(i, stack);
        }

        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }


    private void dfs(int i, Stack<Integer> stack)
    {
        visited[i] = true;
        if (this.graph.get(i) != null)
        {
            Iterator<Integer> itr = this.graph.get(i).iterator();
            while (itr.hasNext())
            {
                int newVertix = itr.next();
                if (this.visited[newVertix] == false)
                    dfs(newVertix, stack);
            }
        }

        stack.push(i);
    }


    public void detectCycle()
    {
        for (int i = 0; i < this.size; i++)
        {
            if (visited[i] == false)
            {
                dfsDetectCycle(i);
            }
        }

    }


    private void dfsDetectCycle(int i)
    {
        beingVisited[i] = true;

        if (this.graph.get(i) != null)
        {
            Iterator<Integer> itr = this.graph.get(i).iterator();
            int newNode = itr.next();

            if (beingVisited[newNode] == true)
            {
                System.out.println("cycle Detected");
                return;
            }

            if (visited[newNode] == false)
                dfsDetectCycle(newNode);
        }

        beingVisited[i] = false;
        visited[i] = true;
    }


    public static void main(String[] args)
    {

        GraphTopologicalSort g = new GraphTopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 5);

        // g.topologicalSort();
        g.detectCycle();
    }

}
