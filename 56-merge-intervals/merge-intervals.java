class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        int[] startingTime = new int[n];
        int[] endingTime = new int[n];

        for(int i = 0; i < n; i++){
            startingTime[i] = intervals[i][0];
            endingTime[i] = intervals[i][1];
        }

        Arrays.sort(startingTime);
        Arrays.sort(endingTime);

        List<int[]> result = new ArrayList<>();

        int start = startingTime[0];
        
        for(int i = 0; i < endingTime.length; i++){

            if( i == n - 1 || startingTime[i + 1] > endingTime[i]){
                result.add(new int[] {start, endingTime[i]});
                
                if(i != n - 1) start = startingTime[i + 1];
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}