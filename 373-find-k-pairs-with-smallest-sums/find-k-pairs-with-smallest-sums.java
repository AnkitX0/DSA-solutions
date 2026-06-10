class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        Set<String> set = new HashSet<>();

        pq.add(new int[] {nums1[0] + nums2[0], 0, 0});

        List<List<Integer>> result = new ArrayList<>();

        while(!pq.isEmpty() && k-- > 0){
            int arr[] = pq.poll();

            int idx1 = arr[1];
            int idx2 = arr[2];

            result.add(new ArrayList<>(List.of(nums1[idx1], nums2[idx2])));

            if(idx2 + 1 < nums2.length && !set.contains(idx1 + "," + (idx2+1))){
                pq.add(new int[] {nums1[idx1] + nums2[idx2 + 1], idx1, idx2 + 1});
                set.add(idx1 + "," + (idx2+1));
            }

            if(idx1 + 1 < nums1.length && !set.contains((idx1 + 1) + "," + idx2)){
                pq.add(new int[] {nums1[idx1 + 1] + nums2[idx2], idx1+ 1, idx2});
                set.add((idx1 + 1)+ "," + idx2);
            }
        }

        return result;
    }
}