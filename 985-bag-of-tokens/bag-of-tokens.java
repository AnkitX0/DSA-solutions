class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;

        if( tokens.length < 1 || tokens[0] > power) return 0; 

        while(left < right){

            if(tokens[left] <= power){
                power -= tokens[left];
                score++;
                left++;
            }
            else{
                power += tokens[right];
                score--;
                right--;
            }
        }
        if(power >= tokens[right]) score++;

        return score;
    }
}