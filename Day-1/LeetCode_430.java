
class Solution {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if(head==null)
        {
            return null;
        }
        Node curr=head;
        while(curr!=null)
        {
            if(curr.child!=null)
            {
                Node ch=curr.child;
                Node temp=ch;
                while(temp.next!=null)
                {
                    temp=temp.next;
                }
                temp.next=curr.next;
                if(curr.next!=null)
                {
                    curr.next.prev=temp;
                }
                curr.next=ch;
                ch.prev=curr;
                curr.child=null;
            }
            curr=curr.next;
        }
        return head;
    }
}