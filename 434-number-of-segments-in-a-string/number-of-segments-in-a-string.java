class Solution {
    public int countSegments(String s) {
        
        if(s.length() == 0) return 0;
        int i = 0;
        int counter = 1;
        
        while(i  < s.length() && s.charAt(i) == ' '){i++;}
        while(i < s.length()){

            if(s.charAt(i) == ' '){
                while(i  < s.length() && s.charAt(i) == ' '){i++;}
                // if (i == s.length()) return counter;
                counter++;
            }
            i++;
        }
        if(s.charAt(s.length()-1) == ' ') counter--; 

        return counter;
    }
}