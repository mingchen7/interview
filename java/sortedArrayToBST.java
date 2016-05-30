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
    public TreeNode sortedArrayToBST(int[] nums){
        if(nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length-1);
    }   
    public TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if(lo == hi){
            return new TreeNode(nums[lo]);
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if(mid - 1 >= lo){
            root.left = sortedArrayToBST(nums, lo, mid-1);    
        }
        else{
            root.left = null;
        }
        if(mid + 1 <= hi){
            root.right = sortedArrayToBST(nums, mid+1, hi);    
        }
        else{
            root.right = null;
        }
        return root;
    }
}