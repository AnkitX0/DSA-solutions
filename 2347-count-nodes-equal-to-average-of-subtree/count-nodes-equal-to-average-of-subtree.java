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
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;

        int sum = avgCounter(root);
        int n = depth(root);

        if(sum / n == root.val) n = 1;
        else n = 0;

        return n + averageOfSubtree(root.left) + averageOfSubtree(root.right);

    }

    public int avgCounter(TreeNode root){
        if(root == null) return 0;
        return root.val + avgCounter(root.left) + avgCounter(root.right);
    }

    public int depth(TreeNode root){
        if(root == null) return 0;

        return 1+ depth(root.left )+ depth(root.right);
    }
}