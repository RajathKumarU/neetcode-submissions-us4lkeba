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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);

        return res;
    }

    public void dfs(TreeNode r, int depth) {
        if(r==null)
            return;

        if(res.size()==depth) {
            res.add(new ArrayList<>());
        }

        res.get(depth).add(r.val);
        dfs(r.left, depth+1);
        dfs(r.right, depth+1);
    }
}
