import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public class Node
    {
        TreeNode node;
        int v;
        
        public Node(TreeNode node, int v) 
        {
            this.node = node;
            this.v = v;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) 
    {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(root, 0));
        int result = 0;

        while(!q.isEmpty()) 
        {
            int size = q.size();
            int left = q.peek().v;
            int right =q.peek().v;

            while (size-- > 0) 
            {
                Node temp = q.poll();

                if (temp.node.left != null) 
                {
                    q.add(new Node(temp.node.left, 2 * temp.v));
                }
                if (temp.node.right != null) 
                {
                    q.add(new Node(temp.node.right, (2 * temp.v) + 1));
                }
                if (size == 0)
                    right = temp.v;
            }
            result = Math.max(result, right - left + 1);
        }
        return result; 
    }
}