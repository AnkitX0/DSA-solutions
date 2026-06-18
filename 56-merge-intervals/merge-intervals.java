class Solution {
    public int[][] merge(int[][] intervals) {
        
        int start[] = new int[intervals.length];
        int end[]   = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i]   = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        List<int []> result = new ArrayList<>();

        int startEle = start[0]; 
        for(int i = 0; i < end.length; i++){

            if(i != intervals.length - 1 && start[i + 1] > end[i]){
                result.add(new int[] {startEle, end[i]});

                if(i != intervals.length - 1) startEle = start[i + 1];
            }
        }
        result.add(new int[] {startEle, end[end.length - 1]});
        return result.toArray(new int[result.size()][]);
    }
}