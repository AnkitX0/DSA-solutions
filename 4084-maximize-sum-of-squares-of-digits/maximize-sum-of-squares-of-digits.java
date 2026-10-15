class Solution {
    public String maxSumOfSquares(int num, int sum) {
        
        if(sum > 9*num) return "";
        StringBuilder sb = new StringBuilder();
        int copy = sum;
        while(num-- > 0){
            if(sum >= 9){
                sb.append("9");
                sum -= 9;
            }
            else {
                sb.append(sum);
                sum = 0;
            }
        }
        return sb.toString();   
    }
}