public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        
        // keep a parent pointer so easy to delete 
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        
        // delete given a parent and its children node
        deleteNode(parent, node);
        
        return dummy.left;
    }
    
    private TreeNode findNode(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return parent;
        }
        
        if (node.val == value) {
            return parent;
        }
        if (value < node.val) {
            return findNode(node, node.left, value);
        } else {
            return findNode(node, node.right, value);
        }
    }
    
    private void deleteNode(TreeNode parent, TreeNode node) {
        // case 1 and case 2, if node has 0 or 1 children
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } 
        // node has 2 children
        else {
            TreeNode temp = node.right;
            TreeNode father = node;
            
            // find the in-order succssor, i.e., left-most node in the right children tree
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            
            // which case of in-order successor is, delete this in-order success temp
            if (father.left == temp) {
                father.left = temp.right;
            } else {
                father.right = temp.right;
            }
            
            // copy temp to the place of node to be deleted
            if (parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            
            // dealing with remain two children tree of node
            temp.left = node.left;
            temp.right = node.right;
        }
    }
}