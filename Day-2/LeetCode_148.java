
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode mid=mid(head);
        ListNode h1=head,h2=mid.next;
        mid.next=null;
        h1=sortList(h1);
        h2=sortList(h2);
        return mergeTwoLists(h1,h2);
    }
    public ListNode mid(ListNode head)
    {
        ListNode slow=head,fast=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        return prev;
    }
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode dummy=new ListNode(-1);
        ListNode ptr=dummy;
        while(h1!=null && h2!=null)
        {
            if(h1.val<=h2.val)
            {
                ptr.next=h1;
                ptr=h1;
                h1=h1.next;
            }
            else
            {
                ptr.next=h2;
                ptr=h2;
                h2=h2.next;
            }
        }
        if(h1==null)
        {
            ptr.next=h2;
        }
        else
        {
            ptr.next=h1;
        }
        return dummy.next;
    }
}