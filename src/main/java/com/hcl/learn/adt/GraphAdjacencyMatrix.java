package com.hcl.learn.adt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjacencyMatrix
{
    List<Vertix> vertices;
    int[][] adjMatrix;
    Stack<Integer> stack;
    Queue<Integer> queue;
    final int MAX_VERTICES;

    public static class Vertix
    {
        char label;
        boolean isVisited = false;

        public Vertix(char label)
        {
            this.label = label;
        }

    }

    public GraphAdjacencyMatrix(int noOfVertices)
    {
        MAX_VERTICES = noOfVertices;
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        vertices = new ArrayList<>();
        stack = new Stack<>();
        queue = new LinkedList<>();
    }


    public void addVertix(char label)
    {
        vertices.add(new Vertix(label));
    }


    public void addEdge(int start, int end)
    {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }


    public void printAdjacencyMatrix()
    {
        for (int i = 0; i < MAX_VERTICES; i++)
        {
            for (int j = 0; j < MAX_VERTICES; j++)
            {
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();
        }

    }


    public void dfs()
    {
        this.markAllUnvisited();

        //STEP : 1 push first element in the stack & mark as visted
        stack.push(0);
        vertices.get(0).isVisited = true;
        printVertix(0);

        //STEP : 2 keep checking stack
        while (!stack.isEmpty())
        {
            //STEP : 3 picking first element from stack

            // go inside list of stack top element
            // if found -1 (no further path available) then it has no use so stack.pop 
            // find first/second "1" and notVisited.
            int v = this.traverseAdjacencyMatrxi(stack.peek());

            if (v == -1)
            {
                stack.pop();
            }
            else
            {
                // mark as visited and put in stack and go deeper and again go back to STEP 3 with new element.
                this.vertices.get(v).isVisited = true;
                // print the element.
                this.printVertix(v);
                stack.push(v);
            }

        }
    }


    public void bfs()
    {
        this.markAllUnvisited();
        //STEP : 1 put first element in queue & mark as visited
        queue.add(0);
        vertices.get(0).isVisited = true;
        printVertix(0);

        //int newVetrix;
        //STEP : 2 keep checking queue
        while (!queue.isEmpty())
        {
            //STEP : 3 deque first element and delete
            int v = queue.remove();
            // go inside the list of queue's element
            // find and equeue all the 1s and notVistied

            for (int i = 0; i < MAX_VERTICES; i++)
            {
                if (adjMatrix[v][i] == 1 && vertices.get(i).isVisited == false)
                {
                    // put in stack go one by one not deeper got back to STEP 3 with all the elements of queue
                    this.vertices.get(i).isVisited = true;
                    // print the element
                    printVertix(i);
                    queue.add(i);
                }
            }

            //            while ((newVetrix = traverseAdjacencyMatrxi(v)) != -1)
            //            {
            //                // put in stack go one by one not deeper got back to STEP 3 with all the elements of queue
            //                this.vertices.get(newVetrix).isVisited = true;
            //                // print the element
            //                printVertix(newVetrix);
            //                queue.add(newVetrix);
            //            }

        }
    }


    private void markAllUnvisited()
    {
        for (Vertix vertix : vertices)
        {
            vertix.isVisited = false;
        }
    }


    private int traverseAdjacencyMatrxi(int vertix)
    {
        for (int i = 0; i < MAX_VERTICES; i++)
        {
            if (adjMatrix[vertix][i] == 1 && vertices.get(i).isVisited == false)
            {
                return i;
            }
        }
        return -1;
    }


    private void printVertix(int index)
    {
        System.out.print(this.vertices.get(index).label);
    }


    public static void main(String[] args)
    {
        GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(6);
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

        graph.printAdjacencyMatrix();
        System.out.println("======");
        graph.dfs();
        System.out.println();
        System.out.println("======");
        graph.bfs();
    }

}
