/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();
    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {    
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode temp = que.poll();

            if(temp.left != null){
                parent.put(temp.left, temp);
                que.add(temp.left);
            }
            if(temp.right != null){
                parent.put(temp.right, temp);
                que.add(temp.right);
            }
        }
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        traverse(target, k, visited);
        return ans;

    }

    public void traverse(TreeNode target, int k, Set<TreeNode> visited){
        if(target == null || k < 0) return;

        if(k == 0)  ans.add(target.val);

        if(target.left != null && visited.add(target.left)) traverse(target.left, k - 1,  visited);

        if(target.right != null && visited.add(target.right))   traverse(target.right, k -1,  visited);
        
        TreeNode par = parent.get(target);
        if(par != null && visited.add(par)) traverse(par, k-1,visited);
    }
}