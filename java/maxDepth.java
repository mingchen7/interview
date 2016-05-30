/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
     
    private int max = Integer.MIN_VALUE; 
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        maxDepth(root, 0);
        return max;
    }
    
    public void maxDepth(TreeNode root, int depth){
        if(root == null){
            return;
        }
        depth = depth + 1;
        if(depth > max){
            max = depth;
        }
        maxDepth(root.left, depth);
        maxDepth(root.right, depth);
        return;    
    }
}