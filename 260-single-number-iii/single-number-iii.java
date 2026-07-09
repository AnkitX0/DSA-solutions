class Solution {
    public int[] singleNumber(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if(!set.contains(i)) set.add(i);
            else set.remove(i);
        }
        int result[] = new int[2];
        int z = 0;
        for(int i : set)result[z++] = i;

        return result; 
    }
}