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
    TreeNode startingNode = null;
    int counter = 0;
    public int amountOfTime(TreeNode root, int start) {
        
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        traverse(root, start, map, null);

        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.offer(startingNode);
        startingNode.val = -1;

        int time = -1;

        while(!qu.isEmpty()){
            int size = qu.size();
            while(size-- > 0){
                TreeNode cur = qu.poll();
                if(map.get(cur) != null && map.get(cur).val != -1) {
                    qu.offer(map.get(cur));
                    map.get(cur).val = -1;
                }
                if(cur.left != null && cur.left.val != -1) {
                    qu.offer(cur.left);
                    cur.left.val = -1;
                }
                if(cur.right != null && cur.right.val != -1) {
                    qu.offer(cur.right);
                    cur.right.val = -1;
                }
                
            }
            time++;
        }

        return time;
    }

    public void traverse(TreeNode root, int start, HashMap<TreeNode, TreeNode> map, TreeNode parent){
        if(root == null) return;

        if(root.val == start) startingNode = root;

        map.put(root, parent);
        traverse(root.left,start, map, root);
        traverse(root.right,start, map, root);
        counter++;
    }
}