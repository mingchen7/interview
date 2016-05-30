// binary search tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// BST
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            System.out.println("Root is null!");
        }        
        if(p.val == root.val){
            return p;
        }
        if(q.val == root.val){
            return q;
        }
        if((p.val<root.val && q.val>root.val) || (p.val>root.val && q.val<root.val)){
            return root;
        }        
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return lowestCommonAncestor(root.left,p,q);
        }        
    }
}

// binary tree
public class Solution {
    // 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || root == node1 || root == node2) {
            return root;
        }
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, node1, node2);
        TreeNode right = lowestCommonAncestor(root.right, node1, node2);
        
        // Conquer
        if (left != null && right != null) {
            return root;
        } 
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}


public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        if(hasNode(p,q)) return p;
        if(hasNode(q,p)) return q;
        
        boolean p_left = hasNode(root.left,p);
        boolean q_left = hasNode(root.left,q);
        
        if(p_left != q_left) 
            return root;
        else if(p_left)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }
    
    public boolean hasNode(TreeNode root, TreeNode node){
        if(root == null) return false;
        if(root == node) return true;
        return hasNode(root.left, node) || hasNode(root.right, node);
    }
}