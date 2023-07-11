package com.saltuk.all.nodes.distance.k.in.binary.tree;

import java.util.*;

/**
 * 863. All Nodes Distance K in Binary Tree
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> pathToTarget = findPathToTarget(root, target);

        var answer = new ArrayList<Integer>();

        for (int i = 0; i < pathToTarget.size() && i <= k; ++i) {
            var skipNode = i == 0 ? null : pathToTarget.get(i - 1);
            var res = topDownApproach(pathToTarget.get(i), k - i, 0, skipNode);
            answer.addAll(res);
        }
        return answer;
    }

    private List<Integer> topDownApproach(TreeNode node, int k, int currentStep, TreeNode skipNode) {
        if (node == null) {
            return List.of();
        }
        if (node == skipNode) {
            return List.of();
        }
        if (currentStep == k) {
            return List.of(node.val);
        }
        var leftRes = topDownApproach(node.left, k, currentStep + 1, skipNode);
        var rightRes = topDownApproach(node.right, k, currentStep + 1, skipNode);

        var res = new ArrayList<Integer>();
        res.addAll(leftRes);
        res.addAll(rightRes);
        return res;
    }

    private List<TreeNode> findPathToTarget(TreeNode root, TreeNode target) {
        if(root == null) {
            return null;
        }
        if (root == target) {
            var path = new ArrayList<TreeNode>();
            path.add(root);
            return path;
        }
        var leftRes = findPathToTarget(root.left, target);
        var rightRes = findPathToTarget(root.right, target);

        if (leftRes != null) {
            leftRes.add(root);
            return leftRes;
        } else if (rightRes != null) {
            rightRes.add(root);
            return rightRes;
        } else {
            return null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}