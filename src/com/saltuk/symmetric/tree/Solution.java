package com.saltuk.symmetric.tree;

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
 * 101-symmetric-tree
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isEqualSymmetric(root.left, root.right);
    }

    private boolean isEqualSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }
        if(node1.val != node2.val) {
            return false;
        }
        var symmetricOuter = isEqualSymmetric(node1.left, node2.right);
        if(!symmetricOuter) {
            return false;
        }
        var symmetricInner = isEqualSymmetric(node1.right, node2.left);
        return symmetricInner;
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