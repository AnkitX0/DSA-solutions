class Solution {
    public int numOfStrings(String[] patterns, String word) {

        int counter = 0;

        for(String str : patterns){
            if(str.length() > word.length()) continue;
            int idx = 0;
            for(int i = 0; i < word.length(); i++){
                // System.out.println(i);
                int t = i;
                if(str.charAt(idx) == word.charAt(t)){
                    while(idx < str.length() && t < word.length() &&str.charAt(idx) == word.charAt(t)){
                        idx++;t++;
                    }
                }
                if(idx == str.length()) {counter++;break;}
                idx = 0;
            }
        }
        return counter;
    }
}