class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        HashSet <Integer> set = new HashSet<>();
        HashSet <Integer> set2 = new HashSet<>();

        for (int i : nums2) set2.add(i);
        for (int i : nums1) set.add(i);

        for (int i : set){
            if(set2.contains(i)) result.add(i);
        }

        int [] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}