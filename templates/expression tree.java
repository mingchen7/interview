/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

class TreeNode {
    int value;
    ExpressionTreeNode root;

    public TreeNode (int value, String ss) {
        this.value = value;
        this.root = new ExpressionTreeNode(ss);
    }
}

public class ExpressionTree {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */

     // helper function to set order of operation
     private int getExpressionValue(String symbol, int base) {
         if (symbol.equals("+") || symbol.equals("-")) {
             return 1 + base;
         }

         if (symbol.equals("*") || symbol.equals("/")) {
             return 2 + base;
         }

         return Integer.MAX_VALUE;
     }

    // Example: (2*6-(23+7)/(1+2))
    // monototically increasing stack
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return null;
        }

        int base = 0;
        int value = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;

        for (int i = 0; i <= expression.length; i++) {
            if (i != expression.length) {
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                else if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
                else {
                    value = getExpressionValue(expression[i], base);
                }
            }

            TreeNode right = (i == expression.length? new TreeNode(Integer.MIN_VALUE, ""): new TreeNode(value, expression[i]));

            while (!stack.isEmpty()) {
                if (right.value <= stack.peek().value) {
                    TreeNode current = stack.pop();
                    if (stack.isEmpty()) {
                        right.root.left = current.root;
                    }
                    else {
                        TreeNode left = stack.peek();
                        if (left.value < right.value) {
                            right.root.left = current.root;
                        }
                        else {
                            left.root.right = current.root;
                        }
                    }
                }
                else {
                    break;
                }

            }

            stack.push(right);

        }

        return stack.peek().root.left;

    }

    private int evaluate(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftVal = evaluate(root.left);
        int rightVal = evaluate(root.right);

        if (root.symbol.equals("+")) {
            return leftVal + rightVal;
        }
        else if (root.symbol.equals("-")) {
            return leftVal - rightVal;
        }
        else if (root.symbol.equals("*")) {
            return leftVal * rightVal;
        }
        else if (root.symbol.equals("/")) {
            if (rightVal == 0) {
                System.out.println("Divided by 0!");
                return 0;
            }
            return leftVal / rightVal;
        }
        // leaf node: number
        else {
            return Integer.parseInt(root.symbol);
        }
    }
}
