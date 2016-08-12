/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// pre-order traversal
public class Solution {
	public List<Integer> preorderTraversal (TreeNode root) {
		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> preorder = new ArrayList<Ineger>();

		if (root == null) {
			return preorder;
		}

		stack.push(root);
		while(!stack.empty()){
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}

		return preorder;
	}	
}

// in-order traversal
public class Solution {
	public List<Integer> inorderTraversal (TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> inorder = new ArrayList<Integer>();

		TreeNode node = root;
		while (node != null || !stack.empty()) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			}
			else{
				node = stack.pop();
				inorder.add(node.val);
				node = node.right;
			}
		}

		return inorder;
	}
}

// post-order traversal
public class Solution {
	public List<Integer> postorderTraversal (TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> postorder = new ArrayList<Integer>();

		TreeNode prev = null;
		TreeNode curr = root;

		if (root == null) {
			return postorder;
		}

		stack.push(root);
		while(!stack.empty()) {
			curr = stack.peek();
			// go down the tree
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				}
				else if (curr.right != null) {
					stack.push(curr.right);
				}
			} 
			// going up from the left, try to going down right tree
			else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				}
			}
			// already hit the leaf, going up from the right tree
			else {
				postorder.add(curr.val);
				stack.pop();
			}
			prev = curr;
		}

		return postorder;
	}
}
