public class SegmentTreeNode {
    int start;
    int end;
    int max;   // can be other measures
    public SegmentTreeNode left;
    public SegmentTreeNode right;

    public SegmentTreeNode (int s, int e, int m) {
        this.start = s;
        this.end = e;
        this.max = m;
        this.left = null;
        this.right = null;
    }

}

// segment tree build
// O(T) = 2 O(T/2) + O(1) => O(n)
public SegmentTreeNode build(int[] A) {
    if (A == null || A.length == 0) {
        return null;
    }

    SegmentTreeNode root = helper(A, 0, A.length - 1);
}

private SegmentTreeNode helper(int[] A, int start, int end) {
    if (start < end) {
        return null;
    }

    if (start == end) {
        return new SegmentTreeNode(start, end, A[start]);
    }

    int mid = (start + end) / 2;
    SegmentTreeNode left = helper(A, start, mid);
    SegmentTreeNode right = helper(A, mid+1, end);

    int leftMax = (left == null? Integer.MIN_VALUE: left.max);
    int rightMax = (right == null? Integer.MIN_VALUE: right.max);

    SegmentTreeNode root = new SegmentTreeNode(start, end, Math.max(leftMax, rightMax));
    return root;
}

// update
// O(lgn)
public void modify(SegmentTreeNode root, int index, int value) {
    if (root == null) {
        return;
    }

    if (index < root.start || index > root.end) {
        return;
    }

    if (index == root.start && index == root.end) {
        root.max = value;
        return;
    }

    int mid = (root.start + root.end) / 2;
    if (index >= root.start && index <= mid) {
        modify(root.left, index, value);
    }
    else if (index >= mid + 1 && index <= root.end) {
        modify(root.right, index, value);
    }

    root.max = Math.max(root.left.max, root.right.max);
    return;
}

// query
// worst-case O(n)
public int query (SegmentTreeNode root, int start, int end) {
    if (root == null) {
        return 0;
    }

    if (end < root.start || start > root.end) {
        return 0;
    }

    if (start <= root.start && end >= root.end) {
        return root.count;
    }

    int mid = (root.start + root.end) / 2;
    int leftResult = query(root.left, root.start, Math.min(mid, end));
    int rightResult = query(root.right, Math.max(mid+1, start), root.end);
    // count segment tree
    return leftResult + rightResult;

    // max segment tree
    // return Math.max(leftResult, rightResult)
}
