class Solution {
    public boolean halvesAreAlike(String s) {
        int mid = (s.length() / 2);
        int leftVowel = 0;
        int rightVowel = 0;
        
        HashSet<Character> set = new HashSet<>();
        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char ch : vowel) {
            set.add(ch);
            }

        for(int i = 0; i < mid; i++){
            char ch = s.charAt(i);
            if(set.contains(ch)) {leftVowel++;}

            if(set.contains(s.charAt(mid + i))) {rightVowel++;}
        }
        return leftVowel == rightVowel;
    }
}