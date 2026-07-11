class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        
        String result = "";
        for(String str : words){

            int sum = 0;
            for(char ch : str.toCharArray()){
                sum += weights[ch-'a'];
            }
            result += (char)(122 - (sum%26));
        }
        return result;
    }
}