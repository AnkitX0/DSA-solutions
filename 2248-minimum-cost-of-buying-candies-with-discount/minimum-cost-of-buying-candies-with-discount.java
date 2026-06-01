class Solution {
    public int minimumCost(int[] cost) {
        
        Arrays.sort(cost);

        int money = 0;
        int t = 0;
        // System.out.println(Arrays.toString(cost));

        for(int i = cost.length - 1; i >= 0; i--){
            t++;
            if(t % 3 == 0)continue;
            money += cost[i];
            // System.out.println(cost[i]);

        }
        return money;
    }
}