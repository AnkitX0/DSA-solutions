class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int n = k;
        while(set.contains(k)){
            k += n;
        }
        return k;
    }
}