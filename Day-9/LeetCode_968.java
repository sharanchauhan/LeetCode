
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
    int count=0;
    public int minCameraCover(TreeNode root) {
        count=0;
        int res=status(root);
        if(res==-1)
        {
            count++;
        }
        return count;
    }
    public int status(TreeNode root)
    {
        if(root==null)
        {
            return 1;
        }
        int left=status(root.left);
        int right=status(root.right);
        if(left==-1 || right==-1)
        {
            count++;
            return 0;
        }
        if(left==0 || right==0)
        {
            return 1;
        }
        return -1;
    }
}