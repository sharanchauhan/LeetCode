
class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void deleteNode(ListNode node) {
        int newNode=node.next.val;
        node.val=newNode;
        node.next=node.next.next;
    }
}