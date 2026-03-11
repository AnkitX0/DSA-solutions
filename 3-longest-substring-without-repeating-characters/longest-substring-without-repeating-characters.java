class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max=0;
        int left=0,right=0;
        int size=s.length();
        HashSet<Character> set = new HashSet<>();
        while(right<size){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left +=1;
            }
            set.add(s.charAt(right));
            right++;
            if(right-left >max) max = right-left;
        }
        return max;
    }
}
