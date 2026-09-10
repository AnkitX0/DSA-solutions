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
    public int averageOfSubtree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        int res = 0;

        while(!qu.isEmpty()){
            TreeNode curr = qu.poll();

            int count = counter(curr);
            int sum = subTree(curr);

            if (sum / count == curr.val) res++;


            if(curr.left != null) qu.add(curr.left);
            if(curr.right != null) qu.add(curr.right);
        }
        return res;
    }

    private int counter(TreeNode root){
        if (root == null) return 0;
        return 1 + counter(root.left) + counter(root.right);
    }

    private int subTree(TreeNode root){
        if(root == null) return 0;
        return root.val + subTree(root.left) + subTree(root.right);
    }
}