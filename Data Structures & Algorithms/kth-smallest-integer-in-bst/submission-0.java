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
    List<Integer> inOrder = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);

        return inOrder.get(k-1);
    }

    public void dfs(TreeNode root) {
        
        if(root == null) {
            return;
        }

        dfs(root.left);
        inOrder.add(root.val);
        dfs(root.right);

    }
}
