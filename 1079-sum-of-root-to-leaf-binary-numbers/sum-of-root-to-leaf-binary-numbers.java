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
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        recur(root,0);
        return sum;
    }

    private void recur (TreeNode root, int val){
        if(root == null) {
            return;
        }
        
        val = (val<<1) | root.val;

        if(root.left == null && root.right == null){
            sum += val;
            return;
        }
        
        recur(root.left, val);
        recur(root.right, val);

        // val = val /10;
    }
}