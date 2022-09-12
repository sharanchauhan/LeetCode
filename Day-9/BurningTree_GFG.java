import java.util.ArrayList;

class Solution {
    public class Node 
    {
        int data;
        Node left;
        Node right;

        Node(int data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data){
        if(node==null)
        {
          return new ArrayList<Node>();
        }
        if(node.data==data)
        {
          ArrayList<Node> ans=new ArrayList<>();
          ans.add(node);
          return ans;
        }
        ArrayList<Node> leftChild=nodeToRootPath(node.left, data);
        if(leftChild.size()>0)
        {
          leftChild.add(node);
          return leftChild;
        }
        ArrayList<Node> rightChild=nodeToRootPath(node.right, data);
        if(rightChild.size()>0)
        {
          rightChild.add(node);
          return rightChild;
        }
        return new ArrayList<>();
      }
      
      public static int max(int a,int b)
      {
          if(a>b)
          {
              return a;
          }
          else
          {
              return b;
          }
      }
      public static int height(Node root)
      {
          if(root==null)
          {
              return 0;
          }
          return max(height(root.left),height(root.right))+1;
      }
      
      public static int minTime(Node root, int target) 
      {
          // Your code goes here
          ArrayList<Node> path=nodeToRootPath(root,target);
          if(path==null) return 0;
          int time=0;
          for(int i=0;i<path.size();i++)
          {
              Node node=path.get(i);
              if(i==0)
              {
                  time=height(node)-1;
              }
              else
              {
                  Node child=path.get(i-1);
                  if(child==node.left)
                  {
                      time=max(time,i+height(node.right));
                  }
                  else
                  {
                      time=max(time,i+height(node.left));
                  }
              }
          }
          return time;
      }
}