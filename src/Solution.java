import LinkedList.ListNode;

import javax.swing.tree.TreeNode;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.right=left;
        root.left=right;
        return root;
    }
}


