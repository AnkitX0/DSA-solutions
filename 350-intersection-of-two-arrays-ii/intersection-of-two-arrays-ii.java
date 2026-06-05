class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
     
        List<Integer> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        for (int i : nums2) list1.add(i);
        // for (int i : nums1) set.add(i);

        for (int i : nums1){
            if(list1.contains(i)){
                result.add(i);
                int idx = list1.indexOf(i);
                list1.remove(idx);
            }
        }

        int [] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;   
    }
}