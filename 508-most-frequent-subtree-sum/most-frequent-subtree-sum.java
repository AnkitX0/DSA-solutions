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
    HashMap<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[]{};
        map = new HashMap<>();

        traverse(root);

     Map<Integer, Integer> sortedMap = map.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e2,
                LinkedHashMap::new
        ));

        ArrayList<Integer> list = new ArrayList<>();
        int firstKey = sortedMap.keySet().iterator().next();
        int maxValue = sortedMap.get(firstKey);
        for(int i : sortedMap.keySet()){
            if(maxValue != sortedMap.get(i)) break;
            list.add(i);
        }        
        int result[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public int traverse(TreeNode root){
        if(root == null) return 0;

        int num = root.val + traverse(root.right)  + traverse(root.left);
        map.put(num, map.getOrDefault(num, 0) + 1);

        return num;
        
    }
}