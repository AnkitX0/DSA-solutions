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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        int left = depth(root, 1, x, y);
        int right = depth(root, 1, y, x);

        if(left == Integer.MAX_VALUE || right == Integer.MAX_VALUE) return false;

        return left == right;

    }
    private int depth(TreeNode root, int count, int x, int y){

        if(root == null) return Integer.MIN_VALUE;

        if(root.left != null && root.right != null && 
            ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)))
            return Integer.MAX_VALUE;

        if(root.val == x) return count;

        return Math.max(depth(root.left, count+1, x, y), depth(root.right, count+1, x, y));
    }
}