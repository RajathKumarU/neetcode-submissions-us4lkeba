/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        TreeNode rootSub = findTree(root, subRoot.val);

        return isSameTree(rootSub, subRoot);
    }

    public TreeNode findTree(TreeNode root, int val) {
        if(root == null)
            return null;
        
        if(root.val == val)
            return root;
        
        TreeNode found = findTree(root.left, val);

        if(found == null)
            found = findTree(root.right, val);

        return found;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        
        if(p != null && q != null && p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
            return false;
    }
}
