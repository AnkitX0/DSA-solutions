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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode curr = new TreeNode(val);
            curr.left = root;
            return curr;
        }
        dfs(root, val, depth, 2);
        return root;
    }

    public void dfs(TreeNode root, int val,int depth, int pos){
        if(root == null) return;

        if(pos == depth){

            TreeNode newLeftNode = new TreeNode(val);
            TreeNode newRightNode = new TreeNode(val);
            
            newLeftNode.left = root.left;
            newLeftNode.right = null;

            newRightNode.left = null;
            newRightNode.right = root.right;
            
            root.left = newLeftNode;
            root.right = newRightNode;
            return;
        }
        
        dfs(root.left, val, depth, pos+1);
        dfs(root.right, val, depth, pos+1);

    }
}