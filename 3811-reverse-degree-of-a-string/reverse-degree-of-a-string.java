class Solution {
    public int reverseDegree(String s) {
        
        int sum = 0;

        for (int i = 0; i < s.length(); i++){
            int idx = 26 - (s.charAt(i) -'a');
            sum += idx * (i + 1);
        }

        return sum;
    }
}