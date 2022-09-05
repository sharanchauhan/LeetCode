class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast =head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                ListNode temp=head;
                while(slow!=temp)
                {
                    slow=slow.next;
                    temp=temp.next;
                }
                return slow;
            }
        }
        return null;
    }
}