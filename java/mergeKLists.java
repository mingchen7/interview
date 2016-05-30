//Version 2: using priority queue
//Time complexity: n * (Offer + Remove)=O(n * (lgk + lgk) ) = O(2nlgk)= O(nlgk)
public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0)
        return null;
    PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
        public int compare(ListNode l1, ListNode l2) {
            return l1.val - l2.val; //minHeap: l1.val > l2.val, so the root is the minimum
        }
    });

    for (ListNode l : lists)
        if (l != null)
            pq.offer(l);

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (!pq.isEmpty()) { 
        ListNode cur = pq.poll();
        tail.next = cur;
        tail = tail.next;// Step forward
        if (cur.next != null)
            pq.offer(cur.next);
    }
    return dummy.next;
}


//Version 1: using merge sort
//Time complexity: O(nlgk)
public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) 
        return null;
    return mergeKLists(lists, 0, lists.length - 1);
}

public ListNode mergeKLists(ListNode[] lists, int start, int end) {
    if (start == end)
        return lists[start];
    int mid = (start + end) / 2;
    ListNode l1 = mergeKLists(lists, start, mid);
    ListNode l2 = mergeKLists(lists, mid + 1, end);
    return mergeTwo(l1, l2);
}

//Pop the smaller one as the head, and keep merging
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
