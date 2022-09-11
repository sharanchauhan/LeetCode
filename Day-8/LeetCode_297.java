class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serializeHelper(root,sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root,StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("null ");
            return;
        }
        sb.append(root.val+" ");
        serializeHelper(root.left,sb);
        serializeHelper(root.right,sb);
    }
    int idx=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String input[]=data.split(" ");
        this.idx=0;
        return deserializeHelper(input);
    }
    
    private TreeNode deserializeHelper(String input[])
    {
        if(idx==input.length)
        {
            return null;
        }
        if(input[idx].equals("null"))
        {
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(input[idx]));
        idx++;
        node.left=deserializeHelper(input);
        idx++;
        node.right=deserializeHelper(input);
        return node;
    }
}

