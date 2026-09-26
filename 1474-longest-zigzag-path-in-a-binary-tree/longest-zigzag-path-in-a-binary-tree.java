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
    public int longestZigZag(TreeNode root) {

        return Math.max(traverse(root, 0, 0), traverse(root, 1, 0));
        
    }

    public int traverse (TreeNode root, int dir, int step){
        if(root == null) return step-1;
        int left, right;
        if(dir == 0){
            left = traverse(root.left, (dir)%2, 1);
            right = traverse(root.right, (dir+1)%2, step+1);
        }
        else {
            left = traverse(root.left, (dir+1)%2, step +1);
            right = traverse(root.right, (dir)%2, 1);
        }

        return Math.max(left,Math.max(step, right));        

    }
}