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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return true;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int level = 0;

        while(!qu.isEmpty()){
            int size = qu.size();

            if (level == 0){
                int min = 0;
                while(size --> 0){
                    TreeNode curr = qu.poll();
                    if(curr.val % 2 == 0) return false;
                    if(curr.val <= min) return false;
                    min = curr.val;

                    if(curr.left != null) qu.offer(curr.left);
                    if(curr.right != null) qu.offer(curr.right);
                }
            }
            else {
                int max = Integer.MAX_VALUE;
                while(size --> 0){
                    TreeNode curr = qu.poll();
                    if(curr.val % 2 != 0) return false;
                    if(curr.val >= max) return false;
                    max = curr.val;
                    if(curr.left != null) qu.offer(curr.left);
                    if(curr.right != null) qu.offer(curr.right);
                }
            }

            level = (level + 1) % 2;
        }
        return true;
        
    }
}