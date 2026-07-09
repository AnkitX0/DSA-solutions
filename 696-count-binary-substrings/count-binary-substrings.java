class Solution {
    public int countBinarySubstrings(String s) {
        
        int counter = 0;
        for(int i = 1; i < s.length(); i++){
           
           int left = i -1;
           int right = i;
           if(s.charAt(left) == s.charAt(right)) continue;

           while(left >= 0 && right < s.length() &&
                 s.charAt(left) == s.charAt(i -1) && 
                 s.charAt(right) == s.charAt(i) ){
                counter++;
                left--;
                right++;
           }
        }
        return counter;
    }
}