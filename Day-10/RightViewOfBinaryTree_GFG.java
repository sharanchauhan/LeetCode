import java.util.ArrayList;

class Solution{
    class Node
    {
        int data;
        Node left, right;
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
    //Function to return list containing elements of right view of binary tree.
    int max_level=0;
    ArrayList<Integer> rightView(Node root) {
        //add code here.
        ArrayList<Integer> result = new ArrayList<Integer>();
		rightViewUtil(result, root, 1);
		//returning the list.
		return result;
    }
    void rightViewUtil(ArrayList<Integer> result, Node node, int level)
    {
        //if root is null, we simply return.
        if (node==null) return;
        
        //if this is the first node of its level then it is in the left view.
        if (max_level < level)
        {
            //storing data of current node in list.
            result.add(node.data);
            max_level = level;
        }
        
        //calling function recursively for left and right 
        //subtrees of current node.
        rightViewUtil(result, node.right, level+1);
        rightViewUtil(result, node.left, level+1);
    }
    
}
