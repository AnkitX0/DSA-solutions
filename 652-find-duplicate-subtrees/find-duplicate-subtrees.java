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
    HashMap<String, Integer> map = new HashMap<>();
    List <TreeNode> res = new ArrayList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return res;

    }

    public String dfs (TreeNode root){
        if(root == null) return "#";

        String str = String.valueOf(root.val);

        str = str +"," + dfs(root.left) + "," + dfs(root.right);

        if(map.getOrDefault(str, 0) == 1) {
            res.add(root);
        }
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }
}