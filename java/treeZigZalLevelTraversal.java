/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> nxtRow = new Stack<TreeNode>();
        Stack<TreeNode> curRow;
        int flag = 1;
        nxtRow.push(root);
        while(!nxtRow.empty()){
            curRow = nxtRow;
            nxtRow = new Stack<TreeNode>();
            List<Integer> tmp = new ArrayList<Integer>();
            while(!curRow.empty()){
                TreeNode node = curRow.pop();
                tmp.add(node.val);
                if(flag == 1){
                    if(node.left != null) nxtRow.push(node.left);
                    if(node.right != null) nxtRow.push(node.right);
                }
                else{
                    if(node.right != null) nxtRow.push(node.right);
                    if(node.left != null) nxtRow.push(node.left);
                }
            }
            flag = -1 * flag;
            res.add(tmp);
        }
        return res;
    }
}