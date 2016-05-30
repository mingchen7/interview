/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// recursion version
public class Solution {
    int ans = 0;
    int tmpK = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        tmpK = k;
        inorder(root);
        return ans;
    }
    
    public void inorder(TreeNode root){
        if(root == null || tmpK == 0) return;
        inorder(root.left);
        tmpK--;
        if(tmpK == 0) ans = root.val;
        inorder(root.right);
    }
    
}

// divide-and-conquer version
public class Solution {
    private int ans = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null && k != 0){
            return 0;
        }
        int n = getNodes(root, k);
        return ans;
    }
    
    public int getNodes(TreeNode root, int k){
        if(root == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        left = helper(root.left, k);    
        if(left + 1 == k){
            ans = root.val;
        }
        if(left + 1< k){
            right = helper(root.right, k-left-1);
        }
        return left+right+1;
    }
}

// loop version
import java.util.*;
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while(s.size() > 0 || node != null){
            if(node != null){
                s.push(node);
                node = node.left;
            }
            else{
                node = s.pop();
                k--;
                if(k == 0) return node.val;
                node = node.right;
            }
        }
        return -1;
    }
}