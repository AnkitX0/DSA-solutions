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
    TreeNode ans;
    int d = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans.val;
    }

    public void dfs (TreeNode root, int k){
        if(root == null) return;

        dfs(root.left, k);
        d++;
        if(d == k) ans = root;
        if(d >= k) return;
        dfs(root.right, k);
        
    }
}