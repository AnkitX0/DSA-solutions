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
    int maxiMum = -1001;
    public int maxPathSum(TreeNode root) {
        depth(root);

        return maxiMum;        
    }
    public int depth(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(depth(root.left), 0);
        int right = Math.max(depth(root.right), 0);

        int sum = root.val + left + right;

        maxiMum = Math.max(maxiMum, sum);

        return Math.max(left, right) + root.val;
    }
}