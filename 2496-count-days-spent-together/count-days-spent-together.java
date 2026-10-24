class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
      
        int start = Math.max(getDay(arriveBob),getDay(arriveAlice));
        int end = Math.min(getDay(leaveBob), getDay(leaveAlice));

        if(start > end) return 0;

        return end - start + 1;
    }

    public int getDay(String date){
         int month = Integer.parseInt(date.substring(0, 2));
         int day = Integer.parseInt(date.substring(3, 5));
        
        int days[] = new int [] {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totaldays = 0;
        for(int d = 1; d < month; d++){
            totaldays += days[d];
        }
        return totaldays+day;
    }
}