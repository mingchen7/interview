// Given BST, convert it in such a way every element now contains the sum of elements >= itself
import java.util.*;

public class BST_SumRightSubTree {
	/*
	public int sumTree_Iter(TreeNode root){
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		node = root;
		int sum = 0;
		while(!stack.empty() || node != null){
			if(node != null){
				sum += node.val;
				if(node.right != null)
					stack.push(node.right);
				node = node.left	
			}
			else{
				node = stack.pop();
			}			
		}
		return sum;
	}

	*/

	public int convertTree(TreeNode root){
		if (root == null) {
			return 0;
		}

		int tmp = root.val;
		int sumLeft = convertTree(root.left);
		int sumRight = covertTree(root.right);
		root.val = sumRight + tmp;
		return  sumLeft + sumRight + tmp;
	}
	
	public static void main(Strings args[]){

	}
}