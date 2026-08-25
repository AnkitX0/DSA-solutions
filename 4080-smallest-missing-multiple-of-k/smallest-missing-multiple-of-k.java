class Solution {
    public int missingMultiple(int[] nums, int k) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        int n = k;
        while(k < Integer.MAX_VALUE){
            if(!set.contains(k)) return k;
            k += n;
        }
        return -1;
    }
}