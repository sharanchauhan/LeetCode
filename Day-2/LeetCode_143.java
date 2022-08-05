/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        {
            return;
        }
        ListNode mid=getMid(head);
        ListNode head2=mid.next;
        mid.next=null;
        head2=reverseList(head2);
        
        ListNode p1=head,p2=head2;
        ListNode dummy=new ListNode();
        ListNode p3=dummy;
        while(p1!=null && p2!=null)
        {
            p3.next=p1;
            p1=p1.next;
            p3=p3.next;
            
            p3.next=p2;
            p2=p2.next;
            p3=p3.next;
        }
        p3.next=p1;
    }
    public ListNode getMid(ListNode head){
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev=null,curr=head;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
        return head;
    }
}