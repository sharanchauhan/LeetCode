import java.util.ArrayList;

class Solution
{
    class Node  
    { 
        int data; 
        Node left, right; 
    
        public Node(int d)  
        { 
            data = d; 
            left = right = null; 
        }
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> res=new ArrayList<>();
	    if(node==null) return null;
	    res.add(node.data);
        if(node.left!=null || node.right!=null)
        {
            leftBoundary(node.left,res);
    	    leafNodes(node,res);
    	    revRightBoundary(node.right,res);
        }
	    return res;
	}
	void leftBoundary(Node node,ArrayList<Integer> res)
	{
	    if(node==null) return;
	    if(node.left!=null)
	    {
	        res.add(node.data);
	        leftBoundary(node.left,res);
	    }
	    else if(node.right!=null)
        {
            res.add(node.data);
            leftBoundary(node.right,res);
        }
	}
	void revRightBoundary(Node node,ArrayList<Integer> res)
	{
	    if(node==null) return;
	    if(node.right!=null)
	    {
	        revRightBoundary(node.right,res);
	        res.add(node.data);
	    }
	    else if(node.left!=null)
        {
            revRightBoundary(node.left,res);
            res.add(node.data);
        }
	}
	void leafNodes(Node node,ArrayList<Integer> res)
	{
	    if(node==null) return;
	    if(node.left==null && node.right==null)
	    {
	        res.add(node.data);
	        return;
	    }
	    leafNodes(node.left,res);
	    leafNodes(node.right,res);
	}
}