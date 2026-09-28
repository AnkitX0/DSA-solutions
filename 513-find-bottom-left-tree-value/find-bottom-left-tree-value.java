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
    int ans = 0, deep = 0;
    public int findBottomLeftValue(TreeNode root) {
        bottomRoot(root, 0);
        return ans;
    }
    public int bottomRoot(TreeNode root, int depth){
        if(root == null) return depth;

        int right = bottomRoot(root.right, depth + 1);
        int left = bottomRoot(root.left, depth + 1);

        if(left > deep) {
            ans = root.val;
            deep = depth;
            return depth;
        }

        return depth; 
        
    }
}