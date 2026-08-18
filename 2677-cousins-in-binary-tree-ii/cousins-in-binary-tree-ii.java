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
        
    TreeMap<Integer, Integer> map = new TreeMap<>();
    HashMap<TreeNode, Integer> sibling = new HashMap<>();
        
    public TreeNode replaceValueInTree(TreeNode root) { 
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        sibling.put(root, root.val);
        
        int level = 0;
        while(!que.isEmpty()){
            int size = que.size();

            int sum = 0;
            while(size-- > 0){
                TreeNode curr = que.poll();
                int sib = 0;
                if(curr.left != null){
                    sib += curr.left.val;
                    que.add(curr.left);
                } 
                if(curr.right != null){
                    sib += curr.right.val;
                    que.add(curr.right);
                } 
                sum += curr.val;

                if(curr.left  != null) sibling.put(curr.left, sib);
                if(curr.right != null) sibling.put(curr.right, sib);                
            }
            map.put(level++, sum);
        }
        System.out.println(map);
        System.out.println(sibling);
        dfs(root, 0);
        return root;
    }

    public void dfs(TreeNode root,int level){
        if(root == null) return;
        root.val = (map.get(level) - sibling.get(root));

        dfs(root.left , level  + 1);
        dfs(root.right, level  + 1); 
    }
}