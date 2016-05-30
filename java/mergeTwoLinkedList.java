/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode crt = null;
        if (l1 == null && l2 == null) return null;
        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        
        if(l1.val < l2.val) {
            crt = l1;
            l1 = l1.next;
        }
        else{
          crt = l2;
          l2 = l2.next;
        } 
        head = crt;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                crt.next = l1;    
                l1 = l1.next;
            }
            else{
                crt.next = l2;
                l2 = l2.next;
            }
            crt = crt.next;
        }
        if(l1 == null) crt.next = l2;
        if(l2 == null) crt.next = l1;
        
        return head;
    }
}

// similar version
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null || l2 == null) return l1==null? l2: l1;
    ListNode head = null;
    if(l1.val<=l2.val) {
        head=l1;
        l1=l1.next;
    }
    else {
        head=l2;
        l2=l2.next;
    }
    ListNode temp = head;
    while(l1!=null&&l2!=null){
        if(l1.val<=l2.val) {
            temp.next=l1;
            l1=l1.next;
        }
        else {
            temp.next=l2;
            l2=l2.next;
        };
        temp=temp.next;
    }
    temp.next=l1==null?l2:l1;
    return head;
}


//recursive version
public ListNode mergeTwo(ListNode l1, ListNode l2) {
    if (l1 == null)
        return l2;
    if (l2 == null)
        return l1; 
    if (l1.val < l2.val) {
        l1.next = mergeTwo(l1.next, l2);
        return l1;
    }
    else {
        l2.next = mergeTwo(l2.next, l1);
        return l2;
    }
}