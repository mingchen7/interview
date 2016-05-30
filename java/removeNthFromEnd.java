/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode far = head;
        ListNode close = head;
        ListNode prev = null;
        while(n>1){
            far = far.next;
            if(far == null) return null;
            n--;
        }
        
        //when far hits the last node, close is at the last nth
        while(far.next != null){
            far = far.next;
            prev = close;
            close = close.next;
        }
        
        // the last nth node is the head node
        if(close == head){
            head = head.next;
            close = null;
            far = null;
        }
        else{
            prev.next = prev.next.next;
            close.next = null; 
            close = null;    
            far = null;
        }
        return head;
    }
}