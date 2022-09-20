import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		rightViewUtil(result, root, 1);
		//returning the list.
		return result;
    }    
    int max_level=0;

    public void rightViewUtil(ArrayList<Integer> result, TreeNode node, int level)
    {
        //if root is null, we simply return.
        if (node==null) return;
        
        //if this is the first node of its level then it is in the left view.
        if (max_level < level)
        {
            //storing data of current node in list.
            result.add(node.val);
            max_level = level;
        }
        
        //calling function recursively for left and right 
        //subtrees of current node.
        rightViewUtil(result, node.right, level+1);
        rightViewUtil(result, node.left, level+1);
    }
}