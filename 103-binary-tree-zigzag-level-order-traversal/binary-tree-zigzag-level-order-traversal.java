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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        result.add(new ArrayList<>(List.of(root.val)));
        int dir = 0;

        while(!que.isEmpty()){
            int size = que.size();
            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                if(node.left != null){
                    que.add(node.left);
                    list.add(node.left.val);
                }
                if(node.right != null){
                    que.add(node.right);
                    list.add(node.right.val);    
                }      
            }
            if(list.isEmpty()) continue;
            if(dir++ % 2 == 0) Collections.reverse(list);
            result.add(list);        
        }

        return result;
    }
}