import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Done using Morris method - reverse preorder
// Time Complexity - O(n)
// Space Complexity - O(1) [Using only one variable]

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        while(root!=null)
        {
            if(root.right==null) //root can only be visited once
            {
                ans.add(root.val);
                root=root.left;
            }
            else //root ->first visit or second visit
            {
                TreeNode rootp1=root.right;
                while(rootp1.left!=null && rootp1.left!=root)
                {
                    rootp1=rootp1.left;
                }
                if(rootp1.left==null) //first visit
                {
                    ans.add(root.val);
                    rootp1.left=root; //connect
                    root=root.right;
                }
                else if(rootp1.left==root) //second visit
                {
                    rootp1.left=null; //disconnect
                    root=root.left;
                }
            }
        }
        // Till here reverse preorder is stored in List ans
        Collections.reverse(ans);
        // Reversed the list ans to get the postorder of the given tree
        return ans;
    }
}