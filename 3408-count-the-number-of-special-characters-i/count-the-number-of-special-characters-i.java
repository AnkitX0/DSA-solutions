class Solution {
    public int numberOfSpecialChars(String word) {
        
        HashMap <Character, Integer> ch = new HashMap<>();
        int counter = 0;
        
        for(char c : word.toCharArray()){
            if(c >= 'a' && c <= 'z') 
                // ch.put(c, ch.getOrDefault(c, 0) + 1);
                ch.put(c, 1);
            // else ch.add((char) (c + 32));
        }

        for(char c : word.toCharArray()){
            
            char newChar = (char)(c + 32);
            if(c >= 'A' && c <='Z' && ch.containsKey(newChar)) {

                if(ch.get(newChar) > 0){
                    ch.put(newChar, ch.get(newChar) - 1);
                    counter++;
                }
            }
        }

        return counter;

    }
}