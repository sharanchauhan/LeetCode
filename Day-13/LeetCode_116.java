import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0)
        {
            int size=queue.size();
            Node temp=null;
            while(size-- != 0)
            {
                Node rem=queue.remove();
                if(temp==null)
                {
                    temp=rem;
                }
                else
                {
                    temp.next=rem;
                    temp=temp.next;
                }
                
                if(rem.left!=null) queue.add(rem.left);
                if(rem.right!=null) queue.add(rem.right);
            }
        }
        return root;
    }
}