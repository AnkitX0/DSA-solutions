class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int t = typed.length();
        if(name.charAt(n - 1) != typed.charAt(t - 1)) return false; 
        if(t < n) return false;
        
        int left = 0;
        int right = 0;
        while(left < n && right < t){
            if(name.charAt(left) != typed.charAt(right)) return false;

            int nameCounter = 0;
            int typeCounter = 0;

            while(left < n -1 && name.charAt(left) == name.charAt(left + 1)){
                left++;
                nameCounter++;
            }
            while(right < t -1 && typed.charAt(right) == typed.charAt(right + 1)){
                typeCounter++;
                right++;
            }
            if(typeCounter < nameCounter) return false;
            left++;
            right++;
        }
        return left == n && right == t;
    }
}