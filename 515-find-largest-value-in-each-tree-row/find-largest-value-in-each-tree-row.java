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
class Pair{
    TreeNode node;
    int depth;
    public Pair(TreeNode node, int dep){
        this.node = node;
        this.depth = dep;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue <Pair> que = new LinkedList<>();
        que.add(new Pair(root, Integer.MIN_VALUE));

        while(!que.isEmpty()){
            Pair curr = que.poll();

            int curValue = map.getOrDefault(curr.depth, Integer.MIN_VALUE);
            map.put(curr.depth, ( curValue > curr.node.val ? curValue : curr.node.val));

            if(curr.node.left != null)que.add(new Pair(curr.node.left, curr.depth + 1));
            if(curr.node.right != null)que.add(new Pair(curr.node.right, curr.depth + 1));

        }

        for(int i : map.keySet()){
            res.add(map.get(i));
        }
        return res;
    }
}