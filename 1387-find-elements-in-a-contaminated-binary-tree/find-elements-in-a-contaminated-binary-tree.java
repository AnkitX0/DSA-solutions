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
class FindElements {

    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
    }
    
    public boolean find(int target) {
        root.val = 0;
        return traverse(root, target);
    }

    private boolean traverse(TreeNode root, int target){
        if(root == null) return false;
        if(root.val == target) return true;
        if(root.val == target)  return true;

        if(root.left != null) {
            root.left.val = (root.val)*2 +1;
        } 
        if(root.right != null){
            root.right.val = (root.val)*2 + 2;
        }
        return traverse(root.left, target) || traverse(root.right, target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */