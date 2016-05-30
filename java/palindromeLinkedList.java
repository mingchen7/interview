/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//O(n) time and O(n) space
import java.util.*;
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode node = head;
        int length = 0;
        while(node != null){
            node = node.next;
            length++;
        }
        int mid = length % 2 == 0? length/2: length/2+ 1;
        Stack<Integer> stack = new Stack<>();
        node = head;
        while(mid > 0){
            stack.push(node.val);
            node = node.next;
            mid--;
        }
        if(length % 2 != 0) stack.pop();
        while(node != null){
           int tmp = stack.pop();
           if(tmp != node.val) return false;
           node = node.next;
        }
        return true;
    }
}

// recursion version
private boolean flag = true;

public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    Helper(head, head);
    return flag;
}

private ListNode Helper(ListNode head, ListNode tail) {
    if(tail != null){
        ListNode n = Helper(head, tail.next);
        head = (n != null) ? n : head;
        flag &= (head.val == tail.val); 
        return head.next;
    }
    return null;
}

//O(n) time and O(1) space
public class Solution {
    public boolean isPalindrome(ListNode head) {
        //10:25am - 10:42am
        // steps: 
        // 1. find the mid node
        // 2. reverse the list from mid node to tail, not including the mid node
        // 3. compare the first half and the reversed second half, two cases are ok
        //      - pairwise equal
        //      - pairwise equal until the last pair of <midnode, null>
        if (head == null) {
            return true;
        }
        ListNode mid = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }
        ListNode rightReversed = reverse(mid.next);
        mid.next = null;
        ListNode left = head;
        ListNode right = rightReversed;
        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        // right must be null now
        return left == null || left == mid;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}


