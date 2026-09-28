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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        Queue<TreeNode> que = new LinkedList<>();

        TreeNode startNode = dfs(root, parent, null, start);
        que.add(startNode);
        startNode.val = -1;
        int time = -1;
        while(!que.isEmpty()){
            int size = que.size();
            
            while(size-- > 0){
                TreeNode node = que.poll();

                if(parent.get(node) != null && parent.get(node).val != -1) {
                    que.add(parent.get(node));
                    parent.get(node).val = -1;
                }
                if(node.left != null && node.left.val != -1) {
                    que.add(node.left);
                    node.left.val = -1;
                }
                if(node.right != null && node.right.val != -1) {
                    que.add(node.right);
                    node.right.val = -1;
                }
            }
            time ++;
        }
        return time;        
    }

    public TreeNode dfs (TreeNode root,HashMap<TreeNode, TreeNode> parents, TreeNode parent, int start){
        if(root == null) return null;

        parents.put(root, parent);
        TreeNode left = dfs(root.left, parents, root, start);
        TreeNode right = dfs(root.right, parents, root, start);

        if(left != null) return left;
        if(right != null) return right;
        if(root.val == start) return root;
        return null;
    }
}