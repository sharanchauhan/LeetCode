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


// Code for relative

// class Solution {
//     class Pair {
//         TreeNode node ;
//         int lvl;
//         Pair(TreeNode node, int lvl)
//         {
//             this.node = node ;
//             this.lvl = lvl;
//         }
//     }
//    // idea is to travel eacb node level wise and assign a index which will help to calculate the width at every level
//    public int widthOfBinaryTree(TreeNode root) {
//        if (root == null) return 0;
       
//        Queue<Pair> qq = new ArrayDeque<>();
//        qq.add(new Pair(root, 0));
//        int ans = 0;
//        while (qq.size()> 0)
//        {
//            int size = qq.size();
//            int min = qq.peek().lvl;
           
//            int leftMostNode = 0 ;
//            for (int i = 0 ; i < size ; i++)
//            {
//                Pair rm = qq.remove();
//                TreeNode rmNode = rm.node;
               
//                if(rmNode.left != null)
//                {
//                    int leftLvl = (rm.lvl - min) * 2 + 1 ;
//                    Pair left = new Pair(rmNode.left, leftLvl);
//                    qq.add(left);
//                }
//                if(rmNode.right != null)
//                {
//                    int rightLvl = (rm.lvl - min) * 2 + 2 ;
//                    Pair right = new Pair(rmNode.right, rightLvl);
//                    qq.add(right);
//                }
//                if (i == 0)
//                {
//                    leftMostNode = rm.lvl;
                   
//                }
//                if (i == size -1)
//                {
//                    int rightMostNode =  rm.lvl;
//                    int width = (rightMostNode -leftMostNode ) +1;
//                    ans = Math.max(ans, width);
//                }
//            }
//        }
//        return ans;
//    }
// }