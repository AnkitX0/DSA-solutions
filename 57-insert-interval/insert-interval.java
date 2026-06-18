class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n = intervals.length;

        int start[] = new int[n + 1];
        int end[]   = new int[n  +1];

        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i]      = intervals[i][1];
        }
        start[n] = newInterval[0];
        end[n] = newInterval[1];

        Arrays.sort(start);
        Arrays.sort(end);

        List<int[]> result = new ArrayList<>();

        int startEle = start[0];

        for(int i = 0; i <= n; i++){

            if( i != n && start[i + 1] > end[i]){

                result.add (new int[] {startEle, end[i]});

                if(i != n ) startEle = start[i + 1];
            }
        }

        result.add( new int[] {startEle, end[end.length -1]});

        return result.toArray(new int [result.size()][]);
        
    }
}