package com.hcl.learn.matrix;

public class NumberOfIsland
{
    public static int noOfIsland(char[][] adj)
    {
        if (adj == null || adj.length == 0)
            return 0;

        int noOfIsland = 0;

        for (int i = 0; i < adj.length; i++)
        {
            for (int j = 0; j < adj[i].length; j++)
            {
                if (adj[i][j] == '1')
                {
                    checkMarkSurrounding(adj, i, j);
                    ++noOfIsland;
                }
            }
        }

        return noOfIsland;
    }


    private static void checkMarkSurrounding(char[][] adj, int i, int j)
    {

        if (i < 0 || j < 0 || i >= adj.length || j >= adj[i].length || adj[i][j] == '0')
        {
            return;
        }

        adj[i][j] = '0';

        checkMarkSurrounding(adj, i - 1, j);
        checkMarkSurrounding(adj, i + 1, j);
        checkMarkSurrounding(adj, i, j - 1);
        checkMarkSurrounding(adj, i, j + 1);
    }


    public static void main(String[] args)
    {

//        char[][] adj = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] adj = {{'1', '1', '1'}, {'0', '1', '0'}, {'0', '1', '0'}};
        int noOfIsland = noOfIsland(adj);
        System.out.println(noOfIsland);
    }

}
