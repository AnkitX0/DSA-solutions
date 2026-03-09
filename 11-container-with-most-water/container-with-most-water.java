class Solution {
    public int maxArea(int[] height) {

        int left=0, right= height.length-1, area=0;

        while(left<right){
            int h = Math.min(height[left], height[right]);
            int temp = h * (right-left);
            if(temp>area) area = temp;

            if(height[left]>height[right]) right--;
            else left ++;
        }   
        return area;
    }
}