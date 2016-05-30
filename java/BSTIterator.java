/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
import java.util.*;
public class BSTIterator {
    private Stack<TreeNode> stack;
    private TreeNode curNode;

    public BSTIterator(TreeNode root) {
        curNode = root;
        stack = new Stack<>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty() || curNode != null;
    }

    /** @return the next smallest number */
    public int next() {
        while(curNode != null){
            stack.push(curNode);
            curNode = curNode.left;
        }
        
        curNode = stack.pop();
        int ans = curNode.val;
        curNode = curNode.right;
        return ans;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */