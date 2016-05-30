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
    private List<String> res = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        String path = "";
        getPaths(root, path);
        return res;
    }
    
    public void getPaths(TreeNode root, String path){
        if(root.left == null && root.right == null){
            path = path + root.val+ "";
            res.add(path);                            
            return;
        }
        path = path + root.val + "->";
        if(root.left != null && root.right == null){
            getPaths(root.left, path);    
        }
        else if(root.left == null && root.right != null){
            getPaths(root.right,path);
        }
        else{
            getPaths(root.left, path);
            String right_path = new String(path);
            getPaths(root.right, right_path);
        }
    }
}