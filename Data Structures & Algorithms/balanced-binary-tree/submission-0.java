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
    public boolean isBalanced(TreeNode root) {

        if(root == null)
            return true;
        
        return Math.abs(dfsHeight(root.left) - dfsHeight(root.right)) <=1;
        
    }

    private int dfsHeight(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = dfsHeight(root.left) + 1;
        int right = dfsHeight(root.right) + 1;

        return Math.max(left,right);
    }
}
