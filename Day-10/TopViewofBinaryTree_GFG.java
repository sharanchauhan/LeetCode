import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

class Solution {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    static class Pair
    {
        Node node;
        int level;
        Pair(Node node,int level)
        {
            this.node=node;
            this.level=level;
        }
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        HashMap<Integer,Integer> map=new HashMap<>();
        Queue<Pair> queue=new ArrayDeque<>();
        queue.add(new Pair(root,0));
        int minLevel=0,maxLevel=0;
        while(queue.size()>0)
        {
            Pair rem=queue.remove();
            if(!map.containsKey(rem.level))
            {
                map.put(rem.level,rem.node.data);
            }
            minLevel=Math.min(minLevel,rem.level);
            maxLevel=Math.max(maxLevel,rem.level);
            if(rem.node.left!=null) queue.add(new Pair(rem.node.left,rem.level-1));
            if(rem.node.right!=null) queue.add(new Pair(rem.node.right,rem.level+1));
        }
        ArrayList<Integer> res=new ArrayList<>();
        while(minLevel<=maxLevel)
        {
            res.add(map.get(minLevel));
            minLevel++;
        }
        return res;
    }
}