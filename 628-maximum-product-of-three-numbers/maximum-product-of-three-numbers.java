class Solution {
    public int maximumProduct(int[] nums) {
        int max=-1001,max2=-1002,max3=-1003;
        int nm=1002,nm2=1001;
        for(int i:nums){
            if(i>max){
                max3=max2;
                max2=max;
                max=i;
            }
            else if(i>max2){
                max3=max2;
                max2=i;
            }
            else if(i>max3) max3=i;

            if(i<nm){
                nm2=nm;
                nm=i;
            }
            else if(i<nm2) nm2=i;
        }
        return Math.max(max*max2*max3,nm2*nm*max);
    }
}