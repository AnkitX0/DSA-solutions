class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = (s.length() / 2);
        int leftVowel = 0;
        int rightVowel = 0;
        
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        for(int i = 0; i < mid; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) {leftVowel++;}
            if(set.contains(s.charAt(mid + i))) {rightVowel++;}
        }
        return leftVowel == rightVowel;
    }
}