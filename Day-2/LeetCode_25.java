
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int size(ListNode head)
    {
        int count=0;
        while(head!=null)
        {
            head=head.next;
            count++;
        }
        return count;
    }
    
    public ListNode reverse(ListNode head) {
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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode p1=dummy;
        int work=(size(head))/k;
        ListNode prev=head,curr=head;
        while(work!=0)
        {
            int tmp=k-1;
            while(tmp!=0)
            {
                curr=curr.next;
                tmp--;
            }
            ListNode nbr=curr.next;
            curr.next=null;
            reverse(prev);
            p1.next=curr;
            p1=prev;
            curr=prev=nbr;
            work--;
        }
        p1.next=curr;
        return dummy.next;
    }
}