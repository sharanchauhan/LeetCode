/**
 * Definition for singly-linked list.
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head,fast=head;
        int gap=n-1;
        while(gap!=0)
        {
            fast=fast.next;
            gap--;
        }
        //This is a condition which tells us that the head of the linked list is to be removed
        if(fast.next==null)
        {
            return head.next;
        }
        ListNode prev=null;
        while(fast.next!=null)
        {
            fast=fast.next;
            prev=slow;
            slow=slow.next;
        }
        prev.next=slow.next;
        return head;
    }
}