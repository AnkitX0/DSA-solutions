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
class CBTInserter {
    
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;

    }
    
    public int insert(int val) {
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode root = que.poll();
            if(root.left == null) {
                root.left = new TreeNode(val);
                return root.val;
            }
            else if(root.right == null){
                root.right = new TreeNode(val);
                return root.val;
            }
            else{
                que.add(root.left);
                que.add(root.right);
            }
        }
        return root.val;
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */