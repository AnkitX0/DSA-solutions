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
    List<Integer> arr = new ArrayList<>();
        public TreeNode balanceBST(TreeNode root) {

            traverse(root);
            return buildBalancedBST(0,arr.size()-1);

        }

        private TreeNode buildBalancedBST(int start, int end) {
            if (start > end) return null; 
            
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(arr.get(mid));
            
            root.left = buildBalancedBST(start, mid-1);   
            root.right = buildBalancedBST(mid+1, end); 
            return root;
        }
    private void traverse(TreeNode root){
        if(root == null) return;

        traverse(root.left);
        arr.add(root.val);  
        traverse(root.right);
    }
}