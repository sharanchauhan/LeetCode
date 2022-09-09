import java.util.ArrayList;
import java.util.List;

// Done using Morris method
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        while(root!=null)
        {
            if(root.left==null) //root can only be visited once
            {
                ans.add(root.val);
                root=root.right;
            }
            else //root ->first visit or second visit
            {
                TreeNode rootp1=root.left;
                while(rootp1.right!=null && rootp1.right!=root)
                {
                    rootp1=rootp1.right;
                }
                if(rootp1.right==null) //first visit
                {
                    ans.add(root.val);
                    rootp1.right=root; //connect
                    root=root.left;
                }
                else if(rootp1.right==root) //second visit
                {
                    rootp1.right=null; //disconnect
                    root=root.right;
                }
            }
        }
        return ans;
    }
}