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
    TreeNode root;
    int idx;
    int depth;
    public Pair(TreeNode root, int idx, int depth){
        this.idx = idx;
        this.root = root;
        this.depth = depth;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, 0, 0));

        while(!que.isEmpty()){
            Pair curr = que.poll();

            if(map.containsKey(curr.idx)){
                TreeMap<Integer, List<Integer>> height = map.get(curr.idx);  

                List<Integer> lis = (!height.containsKey(curr.depth)) ? new ArrayList<>() : height.get(curr.depth);

                lis.add(curr.root.val);
                height.put(curr.depth, lis);
                map.put(curr.idx, height); 
            }

            else{
                TreeMap<Integer, List<Integer>> height = new TreeMap<>();
                List<Integer> lis = new ArrayList<>();
                lis.add(curr.root.val);
                height.put(curr.depth, lis);
                map.put(curr.idx, height);
            }

            if(curr.root.right != null) que.add(new Pair(curr.root.right, curr.idx + 1, curr.depth + 1));
            if(curr.root.left != null) que.add(new Pair(curr.root.left, curr.idx - 1, curr.depth + 1));
        }

        for(int  i : map.keySet()){
            TreeMap<Integer, List<Integer>> h = map.get(i);
            List<Integer> row = new ArrayList<>();
            for(int depth : h.keySet()){
                List<Integer> lis = h.get(depth);
                Collections.sort(lis);  
                row.addAll(lis);
            }
            ans.add(row);
        }
        return ans;
    }
}