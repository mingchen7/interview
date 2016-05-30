/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second;
        ListNode last = dummy;
        if(head == null) return head;
        if(head.next != null) second = head.next;
        else return head;
        
        while(first != null && second !=null){
            // swap pairs
            first.next = second.next;
            second.next = first;
            last.next = second;
            
            // update nodes
            // return if only no node or only one node left
            if(first.next == null || first.next.next == null) return dummy.next;
            last = first;
            second = first.next.next;  
            first = first.next;
        }
        return dummy.next;
    }
}