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
    public int sumNumbers(TreeNode root) {
        
        traverse(root, 0);
        return totalSum;
    }

    public void traverse(TreeNode root, int sum){
        sum =(sum* 10) + root.val;
        
        if(root.left == null && root.right == null ) totalSum += sum;

        
        if(root.left != null)  traverse(root.left, sum);
        if(root.right != null) traverse(root.right, sum);

    }
}