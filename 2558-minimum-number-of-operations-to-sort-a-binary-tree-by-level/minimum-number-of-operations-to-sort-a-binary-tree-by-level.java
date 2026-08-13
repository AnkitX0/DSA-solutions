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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int countSwap = 0;
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            
            List<Integer> row = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = que.poll();
                row.add(temp.val);
                if(temp.left != null) que.add(temp.left);
                if(temp.right != null) que.add(temp.right);
            }
            countSwap += swap(row);
        }
        return countSwap;
    }

    public int swap(List<Integer> list) {

        int n = list.size();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = list.get(i);
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i][1] == i) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j][1];
                cycleSize++;
            }
            swaps += cycleSize - 1;
        }
        return swaps;
    }
}