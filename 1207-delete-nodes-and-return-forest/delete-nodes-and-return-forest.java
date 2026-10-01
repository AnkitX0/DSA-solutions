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
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        HashSet<Integer> set = new HashSet<>();
        for(int i : to_delete) set.add(i);
        if(!set.contains(root.val)) result.add(root);
        root = dfs(root, set);
        
        return result;
    }

    public TreeNode dfs (TreeNode root, HashSet<Integer> set){
        if(root == null) return null;

        root.left = dfs(root.left, set);
        root.right = dfs(root.right, set);

        if(set.contains(root.val)) {
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);
            return null;
        }
        return root;
    }
}