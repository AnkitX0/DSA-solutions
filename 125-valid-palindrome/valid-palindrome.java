class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder sb = new StringBuilder();
        char[] st = s.toCharArray();
        for(char ch : st){
            ch = Character.toLowerCase(ch);
            if(( ch < 'a' || ch > 'z') && (ch < '0' || ch > '9' )) continue;
            sb.append(ch);
            System.out.print(ch);
        }
        int left = 0;
        int right = sb.length()-1;
        // if(right < 2) return false;
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right))return false;
            left++;
            right--;
        }

        return true;       
        
    }
}