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
    public TreeNode getTail(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
    public void flatten(TreeNode root) {
        if(root==null)
        {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null)
        {
            TreeNode lchild=root.left;
            TreeNode rchild=root.right;
            TreeNode tail_lchild=getTail(lchild);
            
            root.right=lchild;
            tail_lchild.right=rchild;
            root.left=null;
        }
    }
}