/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //boundary check
        if(headA == null || headB == null) return null;
    
        ListNode a = headA;
        ListNode b = headB;
    
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }
    
        return a;   
    }
}


//Another interesting version
//Assumption: a loop exists
//Explaination: http://learningarsenal.info/index.php/2015/08/24/detecting-start-of-a-loop-in-singly-linked-list/
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    // find last node of list A (c3)
    ListNode endA = headA;
    while (endA.next != null) {
        endA = endA.next;
    }
    // join c3 to b1 making a c1...c3-b1...b3-c1 loop (if b3 indeed points to c1)
    endA.next = headB;

    ListNode start = null; // if there's no cycle this will stay null
    // Floyd's cycle finder
    ListNode slow = headA, fast = headA;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) { // found a cycle
            // reset to beginning to find cycle start point (c1)
            start = headA;
            while (slow != start) {
                slow = slow.next;
                start = start.next;
            }
            break;
        }
    }
    // unjoin c3-b1
    endA.next = null;
    return start;
}