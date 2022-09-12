//This function should return head to the DLL

class Solution
{
    public class Node
    {
	    Node left, right;
	    int data;
        Node(int d)
        {
            data = d;
            left = right = null;
        }
	
    }
    Node getTail(Node node)
    {
        while(node.right!=null)
        {
            node=node.right;
        }
        return node;
    }
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        if(root==null)
        {
            return null;
        }
        Node lres=bToDLL(root.left);
        Node rres=bToDLL(root.right);
        if(lres==null &&rres==null)
        {
            return root;
        }
        else if(lres==null)
        {
            root.right=rres;
            rres.left=root;
            return root;
        }
        else
        {
            Node temp=getTail(lres);
            root.left=temp;
            temp.right=root;
            if(rres!=null)
            {
                root.right=rres;
                rres.left=root;
            }
            return lres;
        }
    }
}