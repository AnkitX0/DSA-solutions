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
    public int sumOfLeftLeaves(TreeNode root) {
        
        return leftNode(root, 0);

        

    }
        // 0 : right side
        // 1:  left side
    private int leftNode (TreeNode root, int side){

        if(root == null ) return 0;

        if(root.left == null && root.right == null && side == 1) return root.val;

        return leftNode(root.left, 1) + leftNode(root.right, 0);
    }
}