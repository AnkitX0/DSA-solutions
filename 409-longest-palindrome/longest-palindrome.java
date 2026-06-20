class Solution {
    public int longestPalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){

            if(!map.containsKey(ch)) map.put(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }   

        int size = 0;
        int odd = 0;

        for (char ch : map.keySet()){
            int c = map.get(ch); 
            if(c % 2 == 0) size += c;
            else if(c > 1) {
                size += c-1;
                odd++;
                }
            else odd++;
        }

        return odd > 0 ? size + 1 : size;
    }
}