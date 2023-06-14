package com.saltuk.balanced.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 110. Balanced Binary Tree
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        var res = new ArrayList<List<Integer>>();
        pathSum(root, targetSum, new ArrayList<Integer>(), res);
        return res;
    }

    private void pathSum(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> res) {
        currentPath.add(node.val);
        var reducedTarget = targetSum - node.val;

        if(node.left == null && node.right == null) {
            if (reducedTarget == 0) {
                res.add(new ArrayList<Integer>(currentPath));
            }
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        if (reducedTarget < 0) {
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        if(node.left != null) {
            pathSum(node.left, reducedTarget, currentPath, res);
        }
        if(node.right != null) {
            pathSum(node.right, reducedTarget, currentPath, res);
        }
        currentPath.remove(currentPath.size() - 1);
        return;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}