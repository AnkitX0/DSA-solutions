class Solution {
    public int maxProduct(String[] words) {
        
        int ans  = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j < words.length; j++){
                if(words[i].length() * words[j].length() <= ans) continue;
                boolean avail = true;
                for(char ch : words[i].toCharArray()){
                    if(words[j].indexOf(ch) != -1){
                        avail = false;
                        break;
                    }
                }
                if(!avail) continue;
                ans = Math.max(words[i].length() * words[j].length(), ans);
            }   
        }
        return ans;
    }
}