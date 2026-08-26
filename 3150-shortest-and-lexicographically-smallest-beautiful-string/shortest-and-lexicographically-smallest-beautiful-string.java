class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        int one = 0;
        int left = 0;
        String minStr = "";
        for(int i = 0; i < s.length(); i++){
            
            if (s.charAt(i) == '1'){
                one++;
            }
            while(one > k){
                if (s.charAt(left) == '1') one--;
                left++;
            }

            if(one == k){
                int start = left;
                while(start < i && s.charAt(start) == '0') start++;

                String str = s.substring(start, i + 1);
                
                if  (minStr.isEmpty() ||  
                    str.length() < minStr.length() ||
                    (str.length() == minStr.length() && str.compareTo(minStr) < 0)){
                        minStr = str;
                    }
            }
            

        }
        return minStr;
    }
}