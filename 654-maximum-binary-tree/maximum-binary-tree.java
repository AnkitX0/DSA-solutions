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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        return tree(0, nums.length-1, nums);
    }

    public TreeNode tree(int i, int j, int[] nums){
        
        int mid = findMax(i, j, nums);

        TreeNode root = new TreeNode(nums[mid]);

        if(mid <= i) root.left = null;
        else root.left = tree(i, mid-1, nums);
        
        if(mid >= j)root.right = null;
        else root.right = tree( mid+1, j, nums);
    
        return root;
    }

    public int findMax (int i, int j, int[] nums){
        int idx = i;
        for(; i <= j; i++){
            if(nums[i] > nums[idx]) idx = i;
        }
        return idx;
    }
}