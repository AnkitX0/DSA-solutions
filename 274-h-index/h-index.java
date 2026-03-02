class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length ;
        for(int i = 0; i< n ; i++){
            int idx = n - i;
            if(citations[i] >= idx) return idx;
        }
        return 0;
    }
}