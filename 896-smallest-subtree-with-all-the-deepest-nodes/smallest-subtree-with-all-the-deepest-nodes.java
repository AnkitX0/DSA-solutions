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
    class Pair{
        int depth;
        TreeNode root;

        public Pair (int depth, TreeNode root){
            this.depth = depth;
            this.root = root;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair curr = depth ( root,  new Pair(0, root), 0, root);
        return curr.root;
        
    }

    public Pair depth (TreeNode root, Pair curr, int depth, TreeNode parent){
        if(root == null) return new Pair(depth, parent);

        Pair left = depth(root.left, curr, depth + 1, root);
        Pair right = depth(root.right, curr, depth + 1, root);

        if (left.depth > right.depth){
            return left;
        }
        else if (right.depth > left.depth){
            return right;
        }
        
        return new Pair(left.depth, root);
    }
}