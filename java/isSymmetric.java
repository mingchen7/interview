// recursive version
public class Solution {
	public boolean isSymmetric(TreeNode root) {
	    if(root == null) return true;

	    return isSymmetric(root.left, root.right); 
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
	    if(left==null && right==null) return true;
	    if(right==null || left==null) return false;

	    return left.val==right.val  
	        && isSymmetric(left.left, right.right) 
	        && isSymmetric(left.right, right.left);
	}
}


// non-recursive version
import java.util.*;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }
        Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> rightQueue = new LinkedList<TreeNode>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while(!leftQueue.isEmpty() && !rightQueue.isEmpty()){
            if(leftQueue.size() != rightQueue.size()){
                return false;
            }
            int size = leftQueue.size();
            for(int i = 0; i < size; i++){
                TreeNode leftChild = leftQueue.poll();
                TreeNode rightChild = rightQueue.poll();
                if(leftChild.val != rightChild.val){
                    return false;
                }
                if((leftChild.left == null && rightChild.right != null) || (leftChild.left != null && rightChild.right == null)){
                    return false;
                }
                if((leftChild.right == null && rightChild.left != null) || (leftChild.right != null &&  rightChild.left == null)){
                    return false;
                }
                // adding nodes
                if(leftChild.left != null){
                    leftQueue.offer(leftChild.left);
                }
                if(leftChild.right != null){
                    leftQueue.offer(leftChild.right);
                }
                if(rightChild.right != null){
                    rightQueue.offer(rightChild.right);
                }
                if(rightChild.left != null){
                    rightQueue.offer(rightChild.left);
                }
            }
        }
        return true;
    }    
}