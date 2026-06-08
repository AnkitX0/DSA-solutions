class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] word = s.split(" ");
        if(word.length != pattern.length() ) return false;

        HashMap<String, String> map1 = new HashMap<>();

        HashMap<String, String> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++){

            String ch = pattern.substring(i, i+1);
            if(!map1.containsKey(ch) ) map1.put(ch, word[i]);

            if(!map2.containsKey(word[i]))map2.put(word[i], ch);

            if(!map1.get(ch).equals(word[i]) || !map2.get(word[i]).equals(ch)) return false;
        }
        return true;
    }
}