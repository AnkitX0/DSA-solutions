class Solution {
    public char findTheDifference(String s, String t) {
        
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        for(int i = 0; i < charS.length; i++){
            if(charS[i] != charT[i]) return charT[i];
        }

        return charT[charT.length - 1];
    }
}