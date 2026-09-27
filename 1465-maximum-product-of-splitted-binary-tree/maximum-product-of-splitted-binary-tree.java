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
    int totalSum = 0;
    long maxAns = 0;
    public int maxProduct(TreeNode root) {
        totalSum = sum(root);
        dfs(root);
        return (int)(maxAns% 1_000_000_007);
    }

    public int sum (TreeNode root){
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        return left + right + root.val;
    }

    public int dfs (TreeNode root){
        if(root == null) return 0 ;

        int left = dfs(root.left);
        int right = dfs(root.right);

        long max = (Math.max((long)left*(long)(totalSum-left), (long)right * (long)(totalSum - right))) ;

        maxAns = Math.max(maxAns, max);

        return left + right + root.val;
    }
}