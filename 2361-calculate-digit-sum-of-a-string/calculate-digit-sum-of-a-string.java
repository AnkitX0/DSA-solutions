class Solution {
    public String digitSum(String s, int k) {

        while(s.length() > k){
            String sum = "";
            for(int i = 0; i < s.length(); i+=k){
                int cal = 0;
                for(int j = i; j < i+k && j < s.length(); j++){
                    cal += s.charAt(j)-'0';
                }
                sum += cal;
            }
            s = sum;
        }
        return s;
    }
}