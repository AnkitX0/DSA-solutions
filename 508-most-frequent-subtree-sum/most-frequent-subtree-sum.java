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
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[]{};

        traverse(root);

        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == maxFreq) list.add(entry.getKey());
        }
        int ans[] = new int[list.size()];

        for(int i = 0; i < list.size(); i++) ans[i] = list.get(i);

        return ans;

    }

    public int traverse (TreeNode root){
        if(root == null) return 0;

        int sum = root.val + traverse(root.left) + traverse(root.right);

        int freq = map.getOrDefault(sum, 0) + 1;
        map.put(sum, freq);

        maxFreq = Math.max(freq, maxFreq);

        return sum;
    }
}