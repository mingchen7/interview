/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// divide-and-conquer version
public class Solution {
    private class ResultType { 
        int val;
        double diff;
        public ResultType(int val, double diff){
            this.val = val;
            this.diff = diff;
        }
    }
    public int closestValue(TreeNode root, double target) {
        ResultType res = helper(root, target);
        return res.val;
    }
    
    public ResultType helper(TreeNode root, double target) {
        if(root == null){
            return new ResultType(0, Double.MAX_VALUE);
        }
        
        ResultType left = helper(root.left, target);
        ResultType right = helper(root.right, target);
        
        int closestVal = 0;
        double minDiff = 0;
        // get the minimum difference in the left and right tree
        if(left.diff < right.diff){
            minDiff = left.diff;
            closestVal = left.val;
        }
        else{
            minDiff = right.diff;
            closestVal = right.val;
        }
        
        if(Math.abs(root.val - target) < minDiff){
            minDiff = Math.abs((double) root.val - target);
            closestVal = root.val;
        }
        
        return new ResultType(closestVal, minDiff);
    }
}