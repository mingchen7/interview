/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// a shorter version
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}

// dfs version
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return results;
        }
        
        int maxLevel = 0;
        while (true) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if (level.size() == 0) {
                break;
            }
            
            results.add(level);
            maxLevel++;
        }
        
        return results;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> level, int curtLevel, int maxLevel) {
        if (root == null || curtLevel > maxLevel) {
            return;
        }
        
        if (curtLevel == maxLevel) {
            level.add(root.val);
            return;
        }
        
        dfs(root.left, level, curtLevel + 1, maxLevel);
        dfs(root.right, level, curtLevel + 1, maxLevel);
    }
}


import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        LinkedList<TreeNode> curRow = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nxtRow = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        //initialization
        curRow.offer(root);
        nxtRow.offer(root.left);
        nxtRow.offer(root.right);
        ArrayList<Integer> firstrow = new ArrayList<Integer>();
        firstrow.add(root.val);
        ans.add(firstrow);
        while(!nxtRow.isEmpty()){
            curRow = nxtRow;
            nxtRow = new LinkedList<TreeNode>();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while(!curRow.isEmpty()){
                TreeNode node = curRow.poll();
                if(node != null){
                    tmp.add(node.val);    
                    nxtRow.offer(node.left);
                    nxtRow.offer(node.right);
                }
            }
            if(!tmp.isEmpty())
                ans.add(tmp);
        }
        return ans;
        
    }
}

