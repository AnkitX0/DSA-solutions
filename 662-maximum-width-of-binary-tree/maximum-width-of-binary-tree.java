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
    long index;
    TreeNode node;
    public Pair(TreeNode node, long index){
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        long maxWidth = Long.MIN_VALUE;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0));

        while(!que.isEmpty()){
            int size = que.size();

            long first = que.peek().index;
            long last = first;
            while(size-- > 0){

                Pair cur = que.poll();
                last = cur.index;

                long index = cur.index - first;

                if(cur.node.left != null) que.add(new Pair(cur.node.left, 2*index + 1));
                if(cur.node.right != null) que.add(new Pair(cur.node.right, 2*index + 2));
            }
            long width = last - first + 1;

            maxWidth = Math.max(maxWidth, width);
        }

        
        return (int)maxWidth;
    }
}