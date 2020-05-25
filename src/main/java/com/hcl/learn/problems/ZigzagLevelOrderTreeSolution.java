package com.hcl.learn.problems;

import java.util.ArrayList;
import java.util.List;

public class ZigzagLevelOrderTreeSolution
{

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode()
        {}


        TreeNode(int val)
        {
            this.val = val;
        }


        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void reversive(TreeNode node, int level, List<List<Integer>> result)
    {
        //new level created adding root element
        if (level == result.size())
        {
            List<Integer> newNode = new ArrayList<>();
            newNode.add(node.val);
            result.add(newNode);
        }
        else
        {
            // now adding child element- either left or right- one of them on 0th index
            if (level % 2 == 0)
            {
                result.get(level).add(0, node.val);
            }
            else
            {
                result.get(level).add(node.val);
            }

        }

        if (node.right != null)
            reversive(node.right, level + 1, result);

        if (node.left != null)
            reversive(node.left, level + 1, result);

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> resultList = new ArrayList<>();

        reversive(root, 0, resultList);

        System.out.println(resultList);

        return resultList;
    }


    public static void main(String[] args)
    {

        TreeNode root = new TreeNode();
        root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        new ZigzagLevelOrderTreeSolution().zigzagLevelOrder(root);

    }

}
