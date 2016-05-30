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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        findPaths(root, target, path, result);
        return result;
    }
    
    public void findPaths(TreeNode root, int target, List<Integer> path, List<List<Integer>> res){
        if(root.left == null && root.right == null){
            if(root.val == target){
                res.add(new ArrayList<Integer>(path));
                return;
            }
        }
        
        if(root.left != null){
            path.add(root.left.val);
            findPaths(root.left, target-root.val, path, res);
            path.remove(path.size() - 1);
        }
        
        if(root.right != null){
            path.add(root.right.val);
            findPaths(root.right, target-root.val, path, res);
            path.remove(path.size() - 1);
        }
        
        
    }
}