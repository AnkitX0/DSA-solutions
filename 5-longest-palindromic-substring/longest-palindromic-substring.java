class Solution {
    public String longestPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++){

            int left = i;
            int right = i + 1;

            while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
                left--;
                right++;
            }
            
            if(sb.length() < right -left - 1) sb = new StringBuilder(s.substring(left + 1, right));

            left = i;
            right = i;

            while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
                left--;
                right++;
            }
            
            if(sb.length() < (right -left - 1)) sb = new StringBuilder(s.substring(left + 1, right));           

        }

        return sb.toString();
    }
}