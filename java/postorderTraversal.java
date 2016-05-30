/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return new ArrayList<Integer>();
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
}


import java.util.*;
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null ) return new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode node = root;
        TreeNode lastVisited = null;

        while(!stack.empty() || node != null){
            if(node != null){
            	// keep walking the left sub-tree
                stack.push(node);
                node = node.left;
            }
            else{
                TreeNode peekNode = stack.peek();
                // right subtree has not been visisted
                if(peekNode.right != null && lastVisited != peekNode.right){
                    node = peekNode.right; // node is moved through peekNode
                }
                // right subtree has been visisted
                else{
                    // visit node
                    res.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }
        return res;
    }
}