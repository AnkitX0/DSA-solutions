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
    public boolean isSymmetric(TreeNode root) {
        
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;
        
        
        Queue <TreeNode> leftTree = new LinkedList<>();
        Queue <TreeNode> rightTree = new LinkedList<>();

        leftTree.add(root.left);
        rightTree.add(root.right);

        while(!leftTree.isEmpty() && !rightTree.isEmpty()){

            TreeNode leftNum = leftTree.poll();
            TreeNode rightNum = rightTree.poll();

            if(leftNum.val != rightNum.val) return false;

            if(leftNum.right != null && rightNum.left == null  ) return false;
            if(leftNum.left == null && rightNum.right != null  ) return false;
            if(leftNum.right == null && rightNum.left != null  ) return false;
            if(leftNum.left != null && rightNum.right == null  ) return false;

            if(leftNum.left != null)  leftTree.add(leftNum.left);
            if(leftNum.right != null) leftTree.add(leftNum.right);
            if(rightNum.right != null) rightTree.add(rightNum.right);
            if(rightNum.left != null) rightTree.add(rightNum.left);
        }

        if(!leftTree.isEmpty()) return false;
        if(!rightTree.isEmpty()) return false;
        return true;
    }
}