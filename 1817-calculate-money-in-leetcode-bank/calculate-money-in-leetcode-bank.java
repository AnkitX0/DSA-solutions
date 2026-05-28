class Solution {
    public int totalMoney(int n) {

        int monday = 1;
        int totalMoney = 0;
        int day = monday;
        while(n-- > 0){
            if(day % (monday+7) == 0){
                System.out.println(totalMoney);
                day = ++monday;
            } 

            totalMoney += day;
            day++;
            
        }

        return totalMoney;
        
    }
}