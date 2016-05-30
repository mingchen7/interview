/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// my loop version
import java.util.*;
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder.length != inorder.length) return null;
        Stack<TreeNode> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // pre-store index in hashmap        
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        
        // root of the BST
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode node = root;
        stack.push(root);
        for(int i=1; i<preorder.length;i++){
            int val = preorder[i];            
            TreeNode peekNode = stack.peek();
            // insert into the left sub-tree
            if(map.get(val) < map.get(peekNode.val)){
                TreeNode left = new TreeNode(val);
                node.left = left;
                stack.push(left);                
                node = node.left;
            }
            // insert into the right sub-tree
            else{
                // find the position to insert
                while(!stack.empty() && (map.get(val) > map.get(stack.peek().val))){
                    node = stack.pop();                    
                }
                TreeNode right = new TreeNode(val);
                node.right = right;
                stack.push(right);
                node = node.right;
            }
        }
        return root;
    }
}


// a much faster recursive version
// i think this is a O(n) solution
public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();

    for(int i = 0; i < inorder.length; i++) {
        inMap.put(inorder[i], i);
    }

    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    return root;
}

public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
    if(preStart > preEnd || inStart > inEnd) return null;

    TreeNode root = new TreeNode(preorder[preStart]);
    int inRoot = inMap.get(root.val);
    int numsLeft = inRoot - inStart;

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);

    return root;
}