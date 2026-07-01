class Solution {
    public boolean checkIfPangram(String sentence) {

        if(sentence.length() < 26) return false;
        int []alpha = new int[26];

        for(char ch : sentence.toCharArray()){
            alpha[ch-97]++;
        }

        for(int i : alpha) {
            if(i < 1) return false;
        }
        return true;
        
    }
}