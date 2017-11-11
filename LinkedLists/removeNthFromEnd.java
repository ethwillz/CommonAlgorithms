public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode cur = newHead;
    ListNode nth = newHead;
    for(int i = 0; i <= n; i++){
        cur = cur.next;
    }

    while(cur != null){
        cur = cur.next;
        nth = nth.next;
    }
    nth.next = nth.next.next;
    return newHead.next;
}
