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
    PriorityQueue <Integer> pq = new PriorityQueue<>();

    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        traverse(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode temp = dummy;
        while(!pq.isEmpty()){
            TreeNode ele = new TreeNode(pq.poll());
            temp.right = ele;
            temp = temp.right;
        }

        return dummy.right;
    }

    public void traverse(TreeNode root){
        if(root == null) return;
        pq.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}