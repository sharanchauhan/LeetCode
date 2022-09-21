import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

class Tree
{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
    public ArrayList<Integer> diagonal(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> q=new ArrayDeque<>();
        q.add(root);
        while(q.size()>0)
        {
            Node rem=q.remove();
            while(rem!=null)
            {
                ans.add(rem.data);
                if(rem.left!=null) q.add(rem.left);
                rem=rem.right;
            }
        }
        return ans;
    }
}