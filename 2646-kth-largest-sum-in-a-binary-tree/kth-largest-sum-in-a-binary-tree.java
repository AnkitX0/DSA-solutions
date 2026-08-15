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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        que.add(root);

        while(!que.isEmpty()){
            int size = que.size();
            long sum = 0L;
            while(size-- > 0){
                TreeNode curr = que.poll();
                sum += curr.val;

                if(curr.left  != null) que.add(curr.left);
                if(curr.right != null) que.add(curr.right);

            }
            list.add(sum);
        }

        if(list.size() < k) return -1;

        Collections.sort(list);
        return list.get(list.size()-k);
    }
}